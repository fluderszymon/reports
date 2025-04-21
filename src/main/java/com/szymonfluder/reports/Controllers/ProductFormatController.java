package com.szymonfluder.reports.Controllers;

import com.szymonfluder.reports.Entity.ProductFormat;
import com.szymonfluder.reports.dao.ProductFormatDAO;
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
    public void addProductFormat(@RequestBody ProductFormat productFormat) {
        productFormatDAO.addProductFormat(productFormat);
    }

    @GetMapping("/{id}")
    public ProductFormat getProductFormatById(@PathVariable int id) {
        return productFormatDAO.getProductFormatById(id);
    }

    @GetMapping
    public List<ProductFormat> getProductFormats() {
        return productFormatDAO.getAllProductFormats();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProductFormatById(@PathVariable int id) {
        productFormatDAO.deleteProductFormatById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateProductFormat(@RequestBody ProductFormat productFormat) {
        productFormatDAO.updateProductFormat(productFormat);
    }

}
