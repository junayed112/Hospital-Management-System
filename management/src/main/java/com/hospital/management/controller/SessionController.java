package com.hospital.management.controller;

import com.hospital.management.dto.mapper.UserMapper;
import com.hospital.management.dto.request.user.LoginDto;
import com.hospital.management.dto.request.user.ResetPasswordDto;
import com.hospital.management.dto.response.UserDto;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.entity.User;
import com.hospital.management.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserMapper userMapper;


    @PostMapping(value = "/login")
    public ResponseEntity<QueryResponse<UserDto>> loginSystem(@RequestBody LoginDto loginDto) {

        User user = sessionService.login(loginDto.getUsername(), loginDto.getPassword());
        UserDto userDto = userMapper.toDto(user);
        QueryResponse<UserDto> response = new QueryResponse<>(userDto, true, null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/resetpassword")
    public ResponseEntity<QueryResponse<String>> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        User user = sessionService.resetPassword(resetPasswordDto.getToken(), resetPasswordDto.getPassword());
        UserDto userDto = userMapper.toDto(user);

        QueryResponse<String> response = new QueryResponse<>("Password has been reset", true, null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
