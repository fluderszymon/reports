package com.szymonfluder.reports.dao.impl;

import com.szymonfluder.reports.entity.ProductFormat;
import com.szymonfluder.reports.dao.ProductFormatDAO;
import com.szymonfluder.reports.dto.ProductFormatDTO;
import com.szymonfluder.reports.dto.ProductFormatMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductFormatDAOImpl implements ProductFormatDAO {

    private final EntityManager entityManager;
    private final ProductFormatMapper productFormatMapper;

    @Autowired
    public ProductFormatDAOImpl(EntityManager entityManager, ProductFormatMapper productFormatMapper) {
        this.entityManager = entityManager;
        this.productFormatMapper = productFormatMapper;
    }

    @Override
    @Transactional
    public void addProductFormat(ProductFormatDTO productFormatDTO) {
        ProductFormat productFormat = productFormatMapper.productFormatDtoToProductFormat(productFormatDTO);
        Query query = entityManager.createQuery("INSERT INTO ProductFormat (formatName, formatNumber, minLength, " +
                                                "maxLength, minWidth, maxWidth, minHeight, maxHeight, " +
                                                "minWeight, maxWeight, minCompressiveStrengthInMPa) " +
                                                    "VALUES (:formatName, :formatNumber, :minLength, " +
                                                    ":maxLength, :minWidth, :maxWidth, :minHeight, :maxHeight, " +
                                                    ":minWeight, :maxWeight, :minCompressiveStrengthInMPa)")
            .setParameter("formatName", productFormat.getFormatName())
            .setParameter("formatNumber", productFormat.getFormatNumber())
            .setParameter("minLength", productFormat.getMinLength())
            .setParameter("maxLength", productFormat.getMaxLength())
            .setParameter("minWidth", productFormat.getMinWidth())
            .setParameter("maxWidth", productFormat.getMaxWidth())
            .setParameter("minHeight", productFormat.getMinHeight())
            .setParameter("maxHeight", productFormat.getMaxHeight())
            .setParameter("minWeight", productFormat.getMinWeight())
            .setParameter("maxWeight", productFormat.getMaxWeight())
            .setParameter("minCompressiveStrengthInMPa", productFormat.getMinCompressiveStrengthInMPa());

        query.executeUpdate();
    }

    @Override
    public List<ProductFormatDTO> getAllProductFormats() {
        TypedQuery<ProductFormat> query = entityManager.createQuery("FROM ProductFormat", ProductFormat.class);
        return query.getResultList()
                .stream()
                .map(productFormatMapper::productFormatToProductFOrmatDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductFormatDTO getProductFormatById(int id) {
        TypedQuery<ProductFormat> query = entityManager.createQuery("SELECT pf FROM ProductFormat pf " +
                                                                    "WHERE pf.id=:id", ProductFormat.class)
            .setParameter("id", id);

        return productFormatMapper.productFormatToProductFOrmatDto(query.getSingleResult());
    }

    @Override
    @Transactional
    public void deleteProductFormatById(int id) {
        Query query = entityManager.createQuery("DELETE FROM ProductFormat pf WHERE pf.id=:id")
            .setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateProductFormat(ProductFormatDTO productFormatDTO) {
        ProductFormat productFormat = productFormatMapper.productFormatDtoToProductFormat(productFormatDTO);
        Query query = entityManager.createQuery("UPDATE ProductFormat " +
                                                    "SET formatName =:formatName, formatNumber =:formatNumber, " +
                                                    "minLength =:minLength, maxLength =:maxLength, minWidth =:minWidth, " +
                                                    "maxWidth =:maxWidth, minHeight =:minHeight, maxHeight =:maxHeight, " +
                                                    "minWeight =:minWeight, maxWeight =:maxWeight, " +
                                                    "minCompressiveStrengthInMPa =:minCompressiveStrengthInMPa " +
                                                        "WHERE id =:id")
                .setParameter("formatName", productFormat.getFormatName())
                .setParameter("formatNumber", productFormat.getFormatNumber())
                .setParameter("minLength", productFormat.getMinLength())
                .setParameter("maxLength", productFormat.getMaxLength())
                .setParameter("minWidth", productFormat.getMinWidth())
                .setParameter("maxWidth", productFormat.getMaxWidth())
                .setParameter("minHeight", productFormat.getMinHeight())
                .setParameter("maxHeight", productFormat.getMaxHeight())
                .setParameter("minWeight", productFormat.getMinWeight())
                .setParameter("maxWeight", productFormat.getMaxWeight())
                .setParameter("minCompressiveStrengthInMPa", productFormat.getMinCompressiveStrengthInMPa())
                .setParameter("id", productFormat.getId());

        query.executeUpdate();
    }
}
