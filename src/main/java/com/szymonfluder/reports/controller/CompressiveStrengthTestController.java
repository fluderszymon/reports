package com.szymonfluder.reports.controller;

import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import com.szymonfluder.reports.service.CompressiveStrengthTestService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/compressive-strength-tests")
public class CompressiveStrengthTestController {

    private final CompressiveStrengthTestService compressiveStrengthTestService;

    public CompressiveStrengthTestController(CompressiveStrengthTestService compressiveStrengthTestService) {
        this.compressiveStrengthTestService = compressiveStrengthTestService;
    }

    @GetMapping
    public List<CompressiveStrengthTestDTO> findAllCompressiveStrengthTests() {
        return compressiveStrengthTestService.getCompressiveStrengthTests();
    }

    @GetMapping("/{id}")
    public CompressiveStrengthTestDTO getCompressiveStrengthTestById(@PathVariable int id) {
        return compressiveStrengthTestService.getCompressiveStrengthTestById(id);
    }

    @GetMapping("/get-by-employee-id/{id}")
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(@PathVariable("id") int employeeId) {
        return compressiveStrengthTestService.getCompressiveStrengthTestsByEmployeeId(employeeId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addCompressiveStrengthTest(@RequestBody CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        compressiveStrengthTestService.addCompressiveStrengthTest(compressiveStrengthTestDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        compressiveStrengthTestService.deleteCompressiveStrengthTestById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateCompressiveStrengthTest(@RequestBody CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        compressiveStrengthTestService.updateCompressiveStrengthTest(compressiveStrengthTestDTO);
    }
}
