package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.dto.ProductFormatDTO;

import java.util.List;

public interface ProductFormatDAO {

    void addProductFormat(ProductFormatDTO productFormatDTO);
    List<ProductFormatDTO> getAllProductFormats();
    ProductFormatDTO getProductFormatById(int id);
    void deleteProductFormatById(int id);
    void updateProductFormat(ProductFormatDTO productFormatDTO);

}
