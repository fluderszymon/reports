package com.szymonfluder.raports.Controllers;

import com.szymonfluder.raports.Entity.CompressiveStrengthTest;
import com.szymonfluder.raports.Entity.Employee;
import com.szymonfluder.raports.dao.CompressiveStrengthTestDAO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/raports")
public class CompressiveStrengthTestController {

    private final CompressiveStrengthTestDAO compressiveStrengthTestDAO;

    public CompressiveStrengthTestController(CompressiveStrengthTestDAO compressiveStrengthTestDAO) {
        this.compressiveStrengthTestDAO = compressiveStrengthTestDAO;
    }

    @PostMapping("/addCompressiveStrengthTest/{employee_id}/{product_format_id}")
    public void addCompressiveStrengthTest(@PathVariable int employee_id,
                                           @PathVariable int product_format_id,
                                           @RequestBody CompressiveStrengthTest compressiveStrengthTest) {
        compressiveStrengthTestDAO.addCompressiveStrengthTest(employee_id, product_format_id, compressiveStrengthTest);
    }

    @GetMapping("/compressiveStrengthTests/{id}")
    public CompressiveStrengthTest getCompressiveStrengthTestById(@PathVariable int id) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestById(id);
    }

    @GetMapping("/compressiveStrengthTests")
    public List<CompressiveStrengthTest> findAllCompressiveStrengthTests() {
        return compressiveStrengthTestDAO.getCompressiveStrengthTests();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/compressiveStrengthTests/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        compressiveStrengthTestDAO.deleteCompressiveStrengthTestById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateCompressiveStrengthTest/{id}/{employeeId}/{product_format_id}")
    public void updateCompressiveStrengthTest(@PathVariable int id, @PathVariable int employeeId,
                                              @PathVariable int product_format_id,
                                              @RequestBody CompressiveStrengthTest compressiveStrengthTest) {
        compressiveStrengthTestDAO.updateCompressiveStrengthTest(id, employeeId, product_format_id, compressiveStrengthTest);
    }

    @PostMapping("/addCompressiveStrengthTestResults/{id}")
    public void addCompressiveStrengthTestResult(@PathVariable int id, @RequestBody ArrayList<Integer> results) {
        compressiveStrengthTestDAO.addCompressiveStrengthTestResults(id, results);
    }

    @GetMapping("/compressiveStrengthTestsByEmployeeId/{employee_id}")
    public List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(@PathVariable int employee_id) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestsByEmployeeId(employee_id);
    }

}
