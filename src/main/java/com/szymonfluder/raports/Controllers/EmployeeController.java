package com.szymonfluder.raports.Controllers;

import com.szymonfluder.raports.Entity.Employee;
import com.szymonfluder.raports.dao.EmployeeDAO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/raports")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee){
        employeeDAO.addEmployee(employee);
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeDAO.deleteEmployeeById(id);
    }

    @PostMapping("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeDAO.updateEmployee(id, employee);
    }
}

