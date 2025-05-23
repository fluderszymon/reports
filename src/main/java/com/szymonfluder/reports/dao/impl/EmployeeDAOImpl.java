package com.szymonfluder.reports.dao.impl;

import com.szymonfluder.reports.entity.Employee;
import com.szymonfluder.reports.dao.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT u FROM Employee u " +
                        "WHERE u.id=:id", Employee.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        Query query = entityManager.createQuery("INSERT INTO Employee (firstName, lastName, email) " +
                        "VALUES (:firstName, :lastName, :email)")
                .setParameter("firstName", employee.getFirstName())
                .setParameter("lastName", employee.getLastName())
                .setParameter("email", employee.getEmail());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id=:id")
            .setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        Query query = entityManager.createQuery("UPDATE Employee " +
                        "SET firstName =:firstName, lastName =:lastName, email =:email " +
                        "WHERE id=:id")
                .setParameter("firstName", employee.getFirstName())
                .setParameter("lastName", employee.getLastName())
                .setParameter("email", employee.getEmail())
                .setParameter("id", employee.getId());
        query.executeUpdate();
    }
}
