package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.ExternalUserRequestDto;
import com.hospital.management.dto.response.ExternalUserDto;
import com.hospital.management.entity.ExternalUser;
import org.springframework.stereotype.Component;

@Component
public class ExternalUserMapper {
    public ExternalUser toEntity(ExternalUserRequestDto externalUserRequestDto){
        ExternalUser externalUser = new ExternalUser();
        externalUser.setName(externalUserRequestDto.getName());
        externalUser.setMobileNo(externalUserRequestDto.getMobileNo());
        return externalUser;
    }

    public ExternalUserDto toDto(ExternalUser externalUser){
        return new ExternalUserDto(externalUser.getId(), externalUser.getName(),
                externalUser.getMobileNo());
    }

}
