package com.szymonfluder.reports.controller;

import com.szymonfluder.reports.dao.CompressiveStrengthTestDAO;
import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/compressive-strength-tests")
public class CompressiveStrengthTestController {

    private final CompressiveStrengthTestDAO compressiveStrengthTestDAO;

    public CompressiveStrengthTestController(CompressiveStrengthTestDAO compressiveStrengthTestDAO) {
        this.compressiveStrengthTestDAO = compressiveStrengthTestDAO;
    }

    @GetMapping
    public List<CompressiveStrengthTestDTO> findAllCompressiveStrengthTests() {
        return compressiveStrengthTestDAO.getCompressiveStrengthTests();
    }

    @GetMapping("/{id}")
    public CompressiveStrengthTestDTO getCompressiveStrengthTestById(@PathVariable int id) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestById(id);
    }

    @GetMapping("/get-by-employee-id/{employee_id}")
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(@PathVariable int employeeId) {
        return compressiveStrengthTestDAO.getCompressiveStrengthTestsByEmployeeId(employeeId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addCompressiveStrengthTest(@RequestBody CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        compressiveStrengthTestDAO.addCompressiveStrengthTest(compressiveStrengthTestDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        compressiveStrengthTestDAO.deleteCompressiveStrengthTestById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateCompressiveStrengthTest(@RequestBody CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        compressiveStrengthTestDAO.updateCompressiveStrengthTest(compressiveStrengthTestDTO);
    }
}
