package com.szymonfluder.reports.controller;

import com.szymonfluder.reports.dto.UserRegisterDTO;
import com.szymonfluder.reports.entity.User;
import com.szymonfluder.reports.exception.UsernameTakenException;
import com.szymonfluder.reports.service.UserService;
import com.szymonfluder.reports.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterDTO userRegisterDTO) throws Exception {
        userService.register(userRegisterDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }

}
