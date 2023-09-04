package com.hospital.management.controller;

import com.hospital.management.dto.mapper.UserMapper;
import com.hospital.management.dto.request.user.UserRequestDto;
import com.hospital.management.dto.response.UserDto;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.entity.User;
import com.hospital.management.service.CreationService;
import com.hospital.management.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private CreationService creationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getuserdetails/{id}")
    public UserDto retrieveUserDetails(@PathVariable Long id){
        User user = userService.getUserDetailsById(id);
        UserDto userDto = userMapper.toDto(user);
        return userDto;
    }

    @GetMapping("/listBySpeciality/{id}")
    public List<UserDto> retrieveAllDoctorsBySpeciality(@PathVariable Long id){
        List<UserDto> list = userService.findByUserSpeciality(id).stream().map(User -> modelMapper.map(User, UserDto.class))
                .collect(Collectors.toList());
        return list;

    }

    @PostMapping("/registration")
    public UserDto registrationForm(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        user = creationService.registration(user, userRequestDto.getSpecialityId());
        return userMapper.toDto(user);
    }


}
