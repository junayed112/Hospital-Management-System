package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.SpecialityRequestDto;
import com.hospital.management.dto.response.SpecialityDto;
import com.hospital.management.entity.Speciality;
import org.springframework.stereotype.Component;

@Component
public class SpecialityMapper {

    public SpecialityDto toDto(Speciality speciality) {
        return new SpecialityDto(speciality.getId(), speciality.getName());
    }

    public Speciality toSpeciality(SpecialityRequestDto specialityDto) {
        Speciality speciality = new Speciality();
        speciality.setName(specialityDto.getName());
        return speciality;
    }


}
