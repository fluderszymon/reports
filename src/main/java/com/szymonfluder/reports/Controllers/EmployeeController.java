package com.szymonfluder.reports.Controllers;

import com.szymonfluder.reports.Entity.Employee;
import com.szymonfluder.reports.dao.EmployeeDAO;
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeDAO.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeDAO.deleteEmployeeById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
}

