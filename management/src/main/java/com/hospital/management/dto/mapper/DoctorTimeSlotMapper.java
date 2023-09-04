package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.DoctorTimeSlotRequestDto;
import com.hospital.management.dto.response.DoctorTimeSlotDto;
import com.hospital.management.entity.DoctorTimeSlot;
import org.springframework.stereotype.Component;

@Component
public class DoctorTimeSlotMapper {
    public DoctorTimeSlotDto toDto(DoctorTimeSlot doctorTimeSlot){
        return new DoctorTimeSlotDto(doctorTimeSlot.getDoctorId(),
                doctorTimeSlot.getTimeSlotId(), doctorTimeSlot.getDate(), doctorTimeSlot.getAppointmentBooked());
    }
    public DoctorTimeSlot toEntity(DoctorTimeSlotRequestDto doctorTimeSlotRequestDto){
        DoctorTimeSlot doctorTimeSlot = new DoctorTimeSlot();
        doctorTimeSlot.setDoctorId(doctorTimeSlotRequestDto.getDoctorId());
        doctorTimeSlot.setTimeSlotId(doctorTimeSlotRequestDto.getTimeSlotId());
        doctorTimeSlot.setDate(doctorTimeSlotRequestDto.getDate());
        doctorTimeSlot.setAppointmentBooked("No");
        return doctorTimeSlot;
    }
}
