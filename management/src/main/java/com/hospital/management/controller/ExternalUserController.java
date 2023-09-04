package com.hospital.management.controller;

import com.hospital.management.dto.mapper.ExternalUserMapper;
import com.hospital.management.dto.request.user.ExternalUserRequestDto;
import com.hospital.management.dto.response.ExternalUserDto;
import com.hospital.management.entity.ExternalUser;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.service.ExternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalUserController {
    @Autowired
    private ExternalUserService externalUserService;
    @Autowired
    private ExternalUserMapper externalUserMapper;

    @PostMapping("/createexternaluser")
    public ExternalUserDto createExterbalUser(@RequestBody ExternalUserRequestDto externalUserRequestDto){
        ExternalUser externalUser = externalUserMapper.toEntity(externalUserRequestDto);
        externalUser = externalUserService.createUser(externalUser);
        return externalUserMapper.toDto(externalUser);
    }
    @PutMapping("/updateExternalUser")
    public ResponseEntity<QueryResponse<ExternalUserDto> > updateExternalUser(
            @RequestBody ExternalUserRequestDto externalUserRequestDto){
        ExternalUser externalUser = externalUserMapper.toEntity(externalUserRequestDto);
        externalUser = externalUserService.updateUser(externalUser, externalUserRequestDto.getId());
        ExternalUserDto externalUserDto = externalUserMapper.toDto(externalUser);
        QueryResponse<ExternalUserDto> response = new QueryResponse<>(externalUserDto,
                true, null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
