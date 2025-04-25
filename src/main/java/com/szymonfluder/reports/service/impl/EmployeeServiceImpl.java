package com.szymonfluder.reports.service.impl;

import com.szymonfluder.reports.dao.EmployeeDAO;
import com.szymonfluder.reports.dto.EmployeeDTO;
import com.szymonfluder.reports.entity.Employee;
import com.szymonfluder.reports.mapper.EmployeeMapper;
import com.szymonfluder.reports.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeDAO employeeDAO) {
        this.employeeMapper = employeeMapper;
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        return employees
                .stream()
                .map(employeeMapper::employeeToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        return employeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        employeeDAO.updateEmployee(employee);
    }
}
