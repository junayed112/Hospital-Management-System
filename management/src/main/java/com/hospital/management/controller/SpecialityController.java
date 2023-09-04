package com.hospital.management.controller;

import com.hospital.management.dto.mapper.SpecialityMapper;
import com.hospital.management.dto.request.user.SpecialityRequestDto;
import com.hospital.management.dto.response.SpecialityDto;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.entity.Speciality;
import com.hospital.management.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private SpecialityMapper specialityMapper;

    @PostMapping("/addSpeciality")
    public SpecialityDto addSpeciality(@RequestBody SpecialityRequestDto specialityRequestDto) {
        Speciality speciality = specialityMapper.toSpeciality(specialityRequestDto);
        speciality = specialityService.createSpeciality(speciality);
        return specialityMapper.toDto(speciality);
    }

    @PutMapping("/updateSpeciality")
    public ResponseEntity<QueryResponse<SpecialityDto>> updateSpeciality(
            @RequestBody SpecialityRequestDto specialityRequestDto) {
        Speciality speciality = specialityMapper.toSpeciality(specialityRequestDto);
        speciality = specialityService.updateSpeciality(speciality, specialityRequestDto.getId());
        SpecialityDto specialityDto = specialityMapper.toDto(speciality);
        QueryResponse<SpecialityDto> response = new QueryResponse<>(specialityDto,
                true, null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deletespeciality/{id}")
    public ResponseEntity<QueryResponse<String>> deleteSpeciality(@PathVariable Long id) {
        specialityService.DeleteSpeciality(id);
        QueryResponse<String> response = new QueryResponse<>("Data has been deleted Successfully", true, null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}