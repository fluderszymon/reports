package com.szymonfluder.reports.dto;

import com.szymonfluder.reports.Entity.CompressiveStrengthTest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CompressiveStrengthMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "productFormatId", source = "productFormat.id")
    CompressiveStrengthTestDTO compressiveStrengthTestToCompressiveStrengthTestDto(CompressiveStrengthTest compressiveStrengthTest);

    @Mapping(target = "employee.id", source = "employeeId")
    @Mapping(target = "productFormat.id", source = "productFormatId")
    CompressiveStrengthTest compressiveStrengthTestDtoToCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);
}