package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.TimeSlotRequestDto;
import com.hospital.management.dto.response.TimeSlotDto;
import com.hospital.management.entity.TimeSlot;
import org.springframework.stereotype.Component;

@Component
public class TimeSlotMapper {
    public TimeSlotDto toDto(TimeSlot timeSlot){
        return new TimeSlotDto(timeSlot.getId(), timeSlot.getStartTime(),timeSlot.getEndTime());
    }
    public TimeSlot toTimeSlot(TimeSlotRequestDto timeSlotRequestDto){
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(timeSlotRequestDto.getStartTime());
        timeSlot.setEndTime(timeSlotRequestDto.getEndTime());
        return timeSlot;
    }
}
