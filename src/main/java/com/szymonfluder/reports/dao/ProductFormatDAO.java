package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.Entity.ProductFormat;

import java.util.List;

public interface ProductFormatDAO {

    void addProductFormat(ProductFormat productFormat);
    List<ProductFormat> getAllProductFormats();
    ProductFormat getProductFormatById(int id);
    void deleteProductFormatById(int id);
    void updateProductFormat(ProductFormat productFormat);

}
