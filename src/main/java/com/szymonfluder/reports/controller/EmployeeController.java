package com.szymonfluder.reports.controller;

import com.szymonfluder.reports.dao.EmployeeDAO;
import com.szymonfluder.reports.dto.EmployeeDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

   @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDAO.addEmployee(employeeDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeDAO.deleteEmployeeById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDAO.updateEmployee(employeeDTO);
    }
}
