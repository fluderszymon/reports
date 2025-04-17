package com.szymonfluder.raports.dao.impl;

import com.szymonfluder.raports.Entity.CompressiveStrengthTest;
import com.szymonfluder.raports.dao.CompressiveStrengthTestDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompressiveStrengthTestDAOImpl implements CompressiveStrengthTestDAO {

    private final EntityManager entityManager;

    @Autowired
    public CompressiveStrengthTestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addCompressiveStrengthTest(int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest) {
        Query query = entityManager.createNativeQuery("INSERT INTO compressive_strength_test " +
                        "(employee_id, batch, test_date, product_format_id) " +
                        "VALUES (?, ?, ?, ?)")
                .setParameter(1, employee_id)
                .setParameter(2, compressiveStrengthTest.getBatch())
                .setParameter(3, compressiveStrengthTest.getTestDate())
                .setParameter(4, product_format_id);
        query.executeUpdate();
    }

    @Override
    public CompressiveStrengthTest getCompressiveStrengthTestById(int id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst WHERE cst.id=:id", CompressiveStrengthTest.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<CompressiveStrengthTest> getCompressiveStrengthTests() {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("FROM CompressiveStrengthTest", CompressiveStrengthTest.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteCompressiveStrengthTestById(int id) {
        Query query = entityManager.createQuery("DELETE FROM CompressiveStrengthTest cst WHERE cst.id=:id");
        query.setParameter("id", id);
        int num = query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateCompressiveStrengthTest(int id, int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest) {
              Query query = entityManager.createNativeQuery("UPDATE compressive_strength_test " +
                "SET employee_id = ?1, batch = ?2, test_date = ?3, product_format_id = ?4 " +
                "WHERE id =:id")
                .setParameter(1, employee_id)
                .setParameter(2, compressiveStrengthTest.getBatch())
                .setParameter(3, compressiveStrengthTest.getTestDate())
                .setParameter(4, product_format_id);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void addCompressiveStrengthTestResults(int compressiveStrengthTestId, ArrayList<Integer> results) {
        for (int i = 0; i < results.size(); i++) {
            Query query = entityManager.createNativeQuery("INSERT INTO results_in_mpa " +
                    "(compressivestrengthtest_id, result_in_mpa) " +
                    "VALUES (?, ?)");
            query.setParameter(1, compressiveStrengthTestId);
            query.setParameter(2, results.get(i));
            query.executeUpdate();
        }
    }

    @Override
    public List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(int employee_id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst INNER JOIN cst.employee " +
                                                                                "WHERE cst.employee.id =:id", CompressiveStrengthTest.class);
        query.setParameter("id", employee_id);
        return query.getResultList();
    }
}