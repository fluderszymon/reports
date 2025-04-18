package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
    void updateEmployee(Employee employee);

}
