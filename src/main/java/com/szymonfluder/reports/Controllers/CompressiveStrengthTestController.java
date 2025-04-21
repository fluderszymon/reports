package com.szymonfluder.reports.Controllers;

import com.szymonfluder.reports.Entity.CompressiveStrengthTest;
import com.szymonfluder.reports.dao.CompressiveStrengthTestDAO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/compressive-strength-tests")
public class CompressiveStrengthTestController {

    private final CompressiveStrengthTestDAO compressiveStrengthTestDAO;

    public CompressiveStrengthTestController(CompressiveStrengthTestDAO compressiveStrengthTestDAO) {
        this.compressiveStrengthTestDAO = compressiveStrengthTestDAO;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/{employee_id}/{product_format_id}")
    public void addCompressiveStrengthTest(@PathVariable int employee_id,
                                           @PathVariable int product_format_id,
                                           @RequestBody CompressiveStrengthTest compressiveStrengthTest) {
        compressiveStrengthTestDAO.addCompressiveStrengthTest(employee_id, product_format_id, compressiveStrengthTest);
    }

    @GetMapping("/{id}")
    public CompressiveStrengthTest getCompressiveStrengthTestById(@PathVariable int id) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestById(id);
    }

    @GetMapping
    public List<CompressiveStrengthTest> findAllCompressiveStrengthTests() {
        return compressiveStrengthTestDAO.getCompressiveStrengthTests();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        compressiveStrengthTestDAO.deleteCompressiveStrengthTestById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{employeeId}/{product_format_id}")
    public void updateCompressiveStrengthTest(@PathVariable int employeeId, @PathVariable int product_format_id,
                                              @RequestBody CompressiveStrengthTest compressiveStrengthTest) {
        compressiveStrengthTestDAO.updateCompressiveStrengthTest(employeeId, product_format_id, compressiveStrengthTest);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/test-results/{id}")
    public void addCompressiveStrengthTestResult(@PathVariable int id, @RequestBody ArrayList<Integer> results) {
        compressiveStrengthTestDAO.addCompressiveStrengthTestResults(id, results);
    }

    @GetMapping("/get-by-employee-id/{employee_id}")
    public List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(@PathVariable int employee_id) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestsByEmployeeId(employee_id);
    }
}
