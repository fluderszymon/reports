package com.szymonfluder.reports.controllers;

import com.szymonfluder.reports.dao.ProductFormatDAO;
import com.szymonfluder.reports.dto.ProductFormatDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/product-formats")
public class ProductFormatController {

    private final ProductFormatDAO productFormatDAO;

    public ProductFormatController(ProductFormatDAO productFormatDAO) {
        this.productFormatDAO = productFormatDAO;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addProductFormat(@RequestBody ProductFormatDTO productFormatDTO) {
        productFormatDAO.addProductFormat(productFormatDTO);
    }

    @GetMapping("/{id}")
    public ProductFormatDTO getProductFormatById(@PathVariable int id) {
        return productFormatDAO.getProductFormatById(id);
    }

    @GetMapping
    public List<ProductFormatDTO> getProductFormats() {
        return productFormatDAO.getAllProductFormats();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProductFormatById(@PathVariable int id) {
        productFormatDAO.deleteProductFormatById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateProductFormat(@RequestBody ProductFormatDTO productFormatDTO) {
        productFormatDAO.updateProductFormat(productFormatDTO);
    }

}
