package com.szymonfluder.reports.dao.impl;

import com.szymonfluder.reports.Entity.CompressiveStrengthTest;
import com.szymonfluder.reports.dao.CompressiveStrengthTestDAO;
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
    private final String ID_STRING_VALUE = "id";

    @Autowired
    public CompressiveStrengthTestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addCompressiveStrengthTest(int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest) {
        Query query = entityManager.createNativeQuery("INSERT INTO compressive_strength_test " +
                                                      "(employee_id, batch, test_date, product_format_id) " +
                                                      "VALUES (:employee_id, :batch, :test_date, :product_format_id)")
                .setParameter("employee_id", employee_id)
                .setParameter("batch", compressiveStrengthTest.getBatch())
                .setParameter("test_date", compressiveStrengthTest.getTestDate())
                .setParameter("product_format_id", product_format_id);
        query.executeUpdate();
    }

    @Override
    public CompressiveStrengthTest getCompressiveStrengthTestById(int id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst " +
                                                                              "WHERE cst.id=:id", CompressiveStrengthTest.class)
            .setParameter(ID_STRING_VALUE, id);

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
        query.setParameter(ID_STRING_VALUE, id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateCompressiveStrengthTest(int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest) {
              Query query = entityManager.createNativeQuery("UPDATE compressive_strength_test " +
                                                            "SET employee_id =:employee_id, batch =:batch, " +
                                                            "test_date =:test_date, product_format_id =:product_format_id " +
                                                            "WHERE compressive_strength_test.id =:id")
                .setParameter("employee_id", employee_id)
                .setParameter("batch", compressiveStrengthTest.getBatch())
                .setParameter("test_date", compressiveStrengthTest.getTestDate())
                .setParameter("product_format_id", product_format_id);
        query.setParameter(ID_STRING_VALUE, compressiveStrengthTest.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void addCompressiveStrengthTestResults(int compressiveStrengthTestId, ArrayList<Integer> results) {
        for (int i = 0; i < results.size(); i++) {
            Query query = entityManager.createNativeQuery("INSERT INTO results_in_mpa " +
                                                          "(compressivestrengthtest_id, result_in_mpa) " +
                                                          "VALUES (:compressivestrengthtest_id, :result_in_mpa)")
                .setParameter("compressivestrengthtest_id", compressiveStrengthTestId)
                .setParameter("result_in_mpa", results.get(i));
            query.executeUpdate();
        }
    }

    @Override
    public List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(int employee_id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst INNER JOIN cst.employee " +
                                                                              "WHERE cst.employee.id =:id", CompressiveStrengthTest.class)
            .setParameter(ID_STRING_VALUE, employee_id);

        return query.getResultList();
    }
}