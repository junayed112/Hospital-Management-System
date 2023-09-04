package com.hospital.management.controller;

import com.hospital.management.dto.mapper.TimeSlotMapper;
import com.hospital.management.dto.request.user.TimeSlotRequestDto;
import com.hospital.management.dto.response.TimeSlotDto;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.entity.TimeSlot;
import com.hospital.management.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;
    @Autowired
    private TimeSlotMapper timeSlotMapper;

    @PostMapping("/timeslot/create")
    public TimeSlotDto createTimeSlot(@RequestBody TimeSlotRequestDto timeSlotRequestDto){
        TimeSlot timeSlot = timeSlotMapper.toTimeSlot(timeSlotRequestDto);
        timeSlot = timeSlotService.createTimeSlot(timeSlot);
        return timeSlotMapper.toDto(timeSlot);
    }
    @PutMapping("/timeslot/update")
    public ResponseEntity<QueryResponse<TimeSlotDto>> updateTimeSlot(
            @RequestBody TimeSlotRequestDto timeSlotRequestDto){
        TimeSlot timeSlot = timeSlotMapper.toTimeSlot(timeSlotRequestDto);
        timeSlot = timeSlotService.updateTimeSlot(timeSlot, timeSlotRequestDto.getId());
        TimeSlotDto timeSlotDto = timeSlotMapper.toDto(timeSlot);
        QueryResponse<TimeSlotDto> response = new QueryResponse<>(timeSlotDto,true,
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/timeslot/delete/{id}")
    public ResponseEntity<QueryResponse<String> > deleteTimeSlot(@PathVariable Long id){
        timeSlotService.deleteTimeSlot(id);
        QueryResponse<String> response = new QueryResponse<>("Data has been deleted successfully",
                true,
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
