package com.szymonfluder.reports.service.impl;

import com.szymonfluder.reports.dao.ProductFormatDAO;
import com.szymonfluder.reports.dto.ProductFormatDTO;
import com.szymonfluder.reports.entity.ProductFormat;
import com.szymonfluder.reports.mapper.ProductFormatMapper;
import com.szymonfluder.reports.service.ProductFormatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFormatServiceImpl implements ProductFormatService {

    private final ProductFormatDAO productFormatDAO;
    private final ProductFormatMapper productFormatMapper;

    public ProductFormatServiceImpl(ProductFormatDAO productFormatDAO, ProductFormatMapper productFormatMapper) {
        this.productFormatDAO = productFormatDAO;
        this.productFormatMapper = productFormatMapper;
    }

    @Override
    public List<ProductFormatDTO> getAllProductFormats() {
        List<ProductFormat> productFormats = productFormatDAO.getAllProductFormats();
        return productFormats
                .stream()
                .map(productFormatMapper::productFormatToProductFOrmatDto)
                .toList();
    }

    @Override
    public ProductFormatDTO getProductFormatById(int id) {
        ProductFormat productFormat = productFormatDAO.getProductFormatById(id);
        return productFormatMapper.productFormatToProductFOrmatDto(productFormat);
    }

    @Override
    public void addProductFormat(ProductFormatDTO productFormatDTO) {
        ProductFormat productFormat = productFormatMapper.productFormatDtoToProductFormat(productFormatDTO);
        productFormatDAO.addProductFormat(productFormat);
    }

    @Override
    public void deleteProductFormatById(int id) {
        productFormatDAO.deleteProductFormatById(id);
    }

    @Override
    public void updateProductFormat(ProductFormatDTO productFormatDTO) {
        ProductFormat productFormat = productFormatMapper.productFormatDtoToProductFormat(productFormatDTO);
        productFormatDAO.updateProductFormat(productFormat);
    }
}
