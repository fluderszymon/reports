package com.szymonfluder.reports.mapper;

import com.szymonfluder.reports.dto.ProductFormatDTO;
import com.szymonfluder.reports.entity.ProductFormat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface ProductFormatMapper {

    ProductFormatMapper INSTANCE = Mappers.getMapper(ProductFormatMapper.class);

    ProductFormatDTO productFormatToProductFOrmatDto(ProductFormat productFormat);
    ProductFormat productFormatDtoToProductFormat(ProductFormatDTO productFormatDTO);
}
