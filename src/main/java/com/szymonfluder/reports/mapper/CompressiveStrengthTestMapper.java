package com.szymonfluder.reports.mapper;

import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import com.szymonfluder.reports.entity.CompressiveStrengthTest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CompressiveStrengthTestMapper {

    CompressiveStrengthTestMapper INSTANCE = Mappers.getMapper(CompressiveStrengthTestMapper.class);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "productFormat.id", target = "productFormatId")
    CompressiveStrengthTestDTO compressiveStrengthTestToCompressiveStrengthTestDto(CompressiveStrengthTest compressiveStrengthTest);

    @Mapping(source = "employeeId", target = "employee.id")
    @Mapping(source = "productFormatId", target = "productFormat.id")
    CompressiveStrengthTest compressiveStrengthTestDtoToCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);
}
