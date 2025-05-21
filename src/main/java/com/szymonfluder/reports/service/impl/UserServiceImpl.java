package com.szymonfluder.reports.service.impl;

import com.szymonfluder.reports.dao.UserRepository;
import com.szymonfluder.reports.dto.UserRegisterDTO;
import com.szymonfluder.reports.entity.User;
import com.szymonfluder.reports.exception.UsernameTakenException;
import com.szymonfluder.reports.mapper.UserMapper;
import com.szymonfluder.reports.service.JWTService;
import com.szymonfluder.reports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JWTService jwtService;
    private final AuthenticationManager authManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, JWTService jwtService, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    public void register(UserRegisterDTO userRegisterDTO) throws UsernameTakenException {
        if (userRepository.findByUsername(userRegisterDTO.getUsername()) == null ) {
            User user = userMapper.UserRegisterDTOToUser(userRegisterDTO);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole("USER");
            userRepository.save(user);
        } else {
            throw new UsernameTakenException(userRegisterDTO.getUsername());
        }
    }

    public String verify(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null ) {
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if(auth.isAuthenticated()) {
                return jwtService.generateToken(user.getUsername());
            }
        }
        return "Could not verify user";
    }
}
