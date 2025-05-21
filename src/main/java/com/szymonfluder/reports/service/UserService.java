package com.szymonfluder.reports.service;

import com.szymonfluder.reports.dto.UserRegisterDTO;
import com.szymonfluder.reports.entity.User;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO) throws Exception;
    String verify(User user);
}
