package com.szymonfluder.raports.dao;

import com.szymonfluder.raports.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
    void updateEmployee(int id, Employee employee);

}
