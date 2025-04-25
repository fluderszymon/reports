package com.szymonfluder.reports.dao.impl;

import com.szymonfluder.reports.entity.Employee;
import com.szymonfluder.reports.dao.EmployeeDAO;
import com.szymonfluder.reports.dto.EmployeeDTO;
import com.szymonfluder.reports.mapper.EmployeeMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager, EmployeeMapper employeeMapper) {
        this.entityManager = entityManager;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        Query query = entityManager.createQuery("INSERT INTO Employee (firstName, lastName, email) " +
                                                "VALUES (:firstName, :lastName, :email)")
            .setParameter("firstName", employee.getFirstName())
            .setParameter("lastName", employee.getLastName())
            .setParameter("email", employee.getEmail());

        query.executeUpdate();
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT u FROM Employee u " +
                                                                "WHERE u.id=:id", Employee.class)
            .setParameter("id", id);
        return employeeMapper.employeeToEmployeeDto(query.getSingleResult());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList()
                .stream()
                .map(employeeMapper::employeeToEmployeeDto)
                .collect(Collectors.toList());
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
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDTO);
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
