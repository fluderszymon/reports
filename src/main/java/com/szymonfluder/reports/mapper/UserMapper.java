package com.szymonfluder.reports.mapper;

import com.szymonfluder.reports.dto.UserRegisterDTO;
import com.szymonfluder.reports.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRegisterDTO UserToUserRegisterDTO(User user);
    User UserRegisterDTOToUser(UserRegisterDTO userRegisterDTO);
}
