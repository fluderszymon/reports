package com.szymonfluder.reports.service;

import com.szymonfluder.reports.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void addEmployee(EmployeeDTO employeeDTO);
    void deleteEmployeeById(int id);
    void updateEmployee(EmployeeDTO employeeDTO);
}
