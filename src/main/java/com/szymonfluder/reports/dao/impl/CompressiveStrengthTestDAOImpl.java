package com.szymonfluder.reports.dao.impl;

import com.szymonfluder.reports.entity.CompressiveStrengthTest;
import com.szymonfluder.reports.dao.CompressiveStrengthTestDAO;
import com.szymonfluder.reports.dto.CompressiveStrengthTestMapper;
import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompressiveStrengthTestDAOImpl implements CompressiveStrengthTestDAO {

    private final EntityManager entityManager;
    private final CompressiveStrengthTestMapper compressiveStrengthTestMapper;

    @Autowired
    public CompressiveStrengthTestDAOImpl(EntityManager entityManager, CompressiveStrengthTestMapper compressiveStrengthTestMapper) {
        this.entityManager = entityManager;
        this.compressiveStrengthTestMapper = compressiveStrengthTestMapper;
    }

    @Override
    @Transactional
    public void addCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        CompressiveStrengthTest compressiveStrengthTest = compressiveStrengthTestMapper.compressiveStrengthTestDtoToCompressiveStrengthTest(compressiveStrengthTestDTO);
        Query query = entityManager.createNativeQuery("INSERT INTO compressive_strength_test " +
                                                      "(employee_id, batch, measured_strength, test_date, product_format_id) " +
                                                      "VALUES (:employee_id, :batch, :measured_strength, :test_date, :product_format_id)")
                .setParameter("employee_id", compressiveStrengthTest.getEmployee().getId())
                .setParameter("batch", compressiveStrengthTest.getBatch())
                .setParameter("measured_strength", compressiveStrengthTest.getMeasuredStrength())
                .setParameter("test_date", compressiveStrengthTest.getTestDate())
                .setParameter("product_format_id", compressiveStrengthTest.getProductFormat().getId());
        query.executeUpdate();
    }

    @Override
    public CompressiveStrengthTestDTO getCompressiveStrengthTestById(int id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst " +
                                                                              "WHERE cst.id=:id", CompressiveStrengthTest.class)
            .setParameter("id", id);

            return compressiveStrengthTestMapper.compressiveStrengthTestToCompressiveStrengthTestDto(query.getSingleResult());
    }

    @Override
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTests() {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("FROM CompressiveStrengthTest", CompressiveStrengthTest.class);
        return query.getResultList()
                .stream()
                .map(compressiveStrengthTestMapper::compressiveStrengthTestToCompressiveStrengthTestDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteCompressiveStrengthTestById(int id) {
        Query query = entityManager.createQuery("DELETE FROM CompressiveStrengthTest cst WHERE cst.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        CompressiveStrengthTest compressiveStrengthTest = compressiveStrengthTestMapper.compressiveStrengthTestDtoToCompressiveStrengthTest(compressiveStrengthTestDTO);
            Query query = entityManager.createNativeQuery("UPDATE compressive_strength_test " +
                                                            "SET employee_id =:employee_id, batch =:batch, measured_strength =:measured_strength," +
                                                            "test_date =:test_date, product_format_id =:product_format_id " +
                                                            "WHERE compressive_strength_test.id =:id")
              .setParameter("employee_id", compressiveStrengthTest.getEmployee().getId())
              .setParameter("batch", compressiveStrengthTest.getBatch())
              .setParameter("measured_strength", compressiveStrengthTest.getMeasuredStrength())
              .setParameter("test_date", compressiveStrengthTest.getTestDate())
              .setParameter("product_format_id", compressiveStrengthTest.getProductFormat().getId());
        query.setParameter("id", compressiveStrengthTest.getId());
        query.executeUpdate();
    }

    @Override
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(int employee_id) {
        TypedQuery<CompressiveStrengthTest> query = entityManager.createQuery("SELECT cst FROM CompressiveStrengthTest cst INNER JOIN cst.employee " +
                                                                              "WHERE cst.employee.id =:id", CompressiveStrengthTest.class)
            .setParameter("id", employee_id);

        return query.getResultList()
                .stream()
                .map(compressiveStrengthTestMapper::compressiveStrengthTestToCompressiveStrengthTestDto)
                .collect(Collectors.toList());
    }
}