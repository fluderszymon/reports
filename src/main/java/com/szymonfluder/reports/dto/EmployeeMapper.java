package com.szymonfluder.reports.dto;

import com.szymonfluder.reports.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
}
