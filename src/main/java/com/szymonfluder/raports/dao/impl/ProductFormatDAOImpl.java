package com.szymonfluder.raports.dao.impl;

import com.szymonfluder.raports.Entity.ProductFormat;
import com.szymonfluder.raports.dao.ProductFormatDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductFormatDAOImpl implements ProductFormatDAO {

    private final EntityManager entityManager;

    @Autowired
    public ProductFormatDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addProductFormat(ProductFormat productFormat) {
        Query query = entityManager.createNativeQuery("INSERT INTO product_format (format_name, format_number, min_length, " +
                                                        "max_length, min_width, max_width, min_height, max_height, " +
                                                        "min_weight, max_weight, min_compressive_strength_in_mpa) " +
                                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        System.out.println(productFormat);
        query.setParameter(1, productFormat.getFormatName());
        query.setParameter(2, productFormat.getFormatNumber());
        query.setParameter(3, productFormat.getMinLength());
        query.setParameter(4, productFormat.getMaxLength());
        query.setParameter(5, productFormat.getMinWidth());
        query.setParameter(6, productFormat.getMaxWidth());
        query.setParameter(7, productFormat.getMinHeight());
        query.setParameter(8, productFormat.getMaxHeight());
        query.setParameter(9, productFormat.getMinWeight());
        query.setParameter(10, productFormat.getMaxWeight());
        query.setParameter(11, productFormat.getMinCompressiveStrengthInMPa());
        query.executeUpdate();
    }

    @Override
    public List<ProductFormat> getAllProductFormats() {
        TypedQuery<ProductFormat> query = entityManager.createQuery("FROM ProductFormat", ProductFormat.class);
        return query.getResultList();
    }

    @Override
    public ProductFormat getProductFormatById(int id) {
        TypedQuery<ProductFormat> query = entityManager.createQuery("SELECT pf FROM ProductFormat pf WHERE pf.id=:id", ProductFormat.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteProductFormatById(int id) {
        Query query = entityManager.createQuery("DELETE FROM ProductFormat pf WHERE pf.id=:id");
        query.setParameter("id", id);
        int num = query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateProductFormat(int id, ProductFormat productFormat) {
        Query query = entityManager.createNativeQuery("UPDATE product_format " +
                        "SET format_name = ?1, format_number = ?2, min_length = ?3, max_length = ?4, " +
                        "min_width = ?5, max_width = ?6, min_height = ?7, max_height = ?8, min_weight = ?9, " +
                        "max_weight = ?10, min_compressive_strength_in_mpa = ?11 " +
                        "WHERE id =:id")
                .setParameter(1, productFormat.getFormatName())
                .setParameter(2, productFormat.getFormatNumber())
                .setParameter(3, productFormat.getMinLength())
                .setParameter(4, productFormat.getMaxLength())
                .setParameter(5, productFormat.getMinWidth())
                .setParameter(6, productFormat.getMaxWidth())
                .setParameter(7, productFormat.getMinHeight())
                .setParameter(8, productFormat.getMaxHeight())
                .setParameter(9, productFormat.getMinWeight())
                .setParameter(10, productFormat.getMaxWeight())
                .setParameter(11, productFormat.getMinCompressiveStrengthInMPa())
                .setParameter("id", id);
        query.executeUpdate();
    }
}
