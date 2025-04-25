package com.szymonfluder.reports.service;

import com.szymonfluder.reports.dto.ProductFormatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductFormatService {

    List<ProductFormatDTO> getAllProductFormats();
    ProductFormatDTO getProductFormatById(int id);
    void addProductFormat(ProductFormatDTO productFormatDTO);
    void deleteProductFormatById(int id);
    void updateProductFormat(ProductFormatDTO productFormatDTO);

}
