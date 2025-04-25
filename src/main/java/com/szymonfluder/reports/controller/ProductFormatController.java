package com.szymonfluder.reports.controller;

import com.szymonfluder.reports.dto.ProductFormatDTO;
import com.szymonfluder.reports.service.ProductFormatService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/product-formats")
public class ProductFormatController {

    private final ProductFormatService productFormatService;

    public ProductFormatController(ProductFormatService productFormatService) {
        this.productFormatService = productFormatService;
    }

    @GetMapping
    public List<ProductFormatDTO> getProductFormats() {
        return productFormatService.getAllProductFormats();
    }

    @GetMapping("/{id}")
    public ProductFormatDTO getProductFormatById(@PathVariable int id) {
        return productFormatService.getProductFormatById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addProductFormat(@RequestBody ProductFormatDTO productFormatDTO) {
        productFormatService.addProductFormat(productFormatDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProductFormatById(@PathVariable int id) {
        productFormatService.deleteProductFormatById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateProductFormat(@RequestBody ProductFormatDTO productFormatDTO) {
        productFormatService.updateProductFormat(productFormatDTO);
    }
}
