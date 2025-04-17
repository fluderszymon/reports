package com.szymonfluder.raports.Controllers;

import com.szymonfluder.raports.Entity.CompressiveStrengthTest;
import com.szymonfluder.raports.Entity.Employee;
import com.szymonfluder.raports.Entity.ProductFormat;
import com.szymonfluder.raports.dao.ProductFormatDAO;
import com.szymonfluder.raports.dao.impl.ProductFormatDAOImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/raports")
public class ProductFormatController {

    private final ProductFormatDAO productFormatDAO;

    public ProductFormatController(ProductFormatDAO productFormatDAO) {
        this.productFormatDAO = productFormatDAO;
    }

    @PostMapping("/addProductFormat")
    public void addProductFormat(@RequestBody ProductFormat productFormat) {
        productFormatDAO.addProductFormat(productFormat);
    }

    @GetMapping("productFormats/{id}")
    public ProductFormat getProductFormatById(@PathVariable int id) {
        return productFormatDAO.getProductFormatById(id);
    }

    @GetMapping("/productFormats")
    public List<ProductFormat> getProductFormats() {
        return productFormatDAO.getAllProductFormats();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/productFormat/{id}")
    public void deleteProductFormatById(@PathVariable int id) {
        productFormatDAO.deleteProductFormatById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateProductFormat/{id}")
    public void updateProductFormat(@PathVariable int id, @RequestBody ProductFormat productFormat) {
        productFormatDAO.updateProductFormat(id, productFormat);
    }

}
