package com.szymonfluder.raports.dao;

import com.szymonfluder.raports.Entity.ProductFormat;

import java.util.List;

public interface ProductFormatDAO {

    void addProductFormat(ProductFormat productFormat);
    List<ProductFormat> getAllProductFormats();
    ProductFormat getProductFormatById(int id);
    void deleteProductFormatById(int id);
    void updateProductFormat(int id, ProductFormat productFormat);

}
