package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void deleteEmployeeById(int id);
    void updateEmployee(EmployeeDTO employeeDTO);

}
