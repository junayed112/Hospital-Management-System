package com.hospital.management.controller;

import com.hospital.management.dto.mapper.DoctorTimeSlotMapper;
import com.hospital.management.dto.request.user.DoctorTimeSlotRequestDto;
import com.hospital.management.dto.response.DoctorTimeSlotDto;
import com.hospital.management.entity.DoctorTimeSlot;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.service.DoctorTimeSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DoctorTimeSlotController {
    @Autowired
    private DoctorTimeSlotService doctorTimeSlotService;
    @Autowired
    private DoctorTimeSlotMapper doctorTimeSlotMapper;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/availableTimeSlots")
    public List<DoctorTimeSlot> availableSlotByDoctorId(
            @RequestParam("id") Long id,
            @RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date date){

        List<DoctorTimeSlot> list = doctorTimeSlotService.availableTimeSlot(id, date);
//                .stream().map(DoctorTimeSlot -> modelMapper.map(
//                        DoctorTimeSlot,
//                        DoctorTimeSlotDto.class)
//                )
//                .collect(Collectors.toList());
        return list;
    }
    @PostMapping("/assigntimeslot")
    public ResponseEntity<QueryResponse<DoctorTimeSlotDto> > assignDoctorTimeSlot(@RequestBody DoctorTimeSlotRequestDto
                                                                                              doctorTimeSlotRequestDto){
        DoctorTimeSlot doctorTimeSlot = doctorTimeSlotMapper.toEntity(doctorTimeSlotRequestDto);
        doctorTimeSlotService.assignTimeSlot(doctorTimeSlot);
        DoctorTimeSlotDto doctorTimeSlotDto = doctorTimeSlotMapper.toDto(doctorTimeSlot);
        QueryResponse<DoctorTimeSlotDto> response = new QueryResponse<>(doctorTimeSlotDto,
                true, null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deletetimeslot/{id}")
    public ResponseEntity<QueryResponse<String> > deleteTimeSlot(@PathVariable Long id){
        doctorTimeSlotService.deleteDoctorTimeSlot(id);
        QueryResponse<String> response = new QueryResponse<>("Data has been deleted successfully",
                true,
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
