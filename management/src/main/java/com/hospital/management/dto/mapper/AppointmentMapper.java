package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.AppointmentRequestDto;
import com.hospital.management.dto.response.AppointmentDto;
import com.hospital.management.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentRequestDto appointmentRequestDto){
        Appointment appointment = new Appointment();
        appointment.setDate(appointmentRequestDto.getDate());
        appointment.setDoctorId(appointmentRequestDto.getDoctorId());
        appointment.setTimeSlotId(appointmentRequestDto.getTimeSlotId());
        appointment.setPatientId(appointmentRequestDto.getPatientId());
        appointment.setStatus("Active");
        return appointment;
    }
    public AppointmentDto toDto(Appointment appointment){
        return new AppointmentDto(appointment.getId(), appointment.getDate(), appointment.getDoctorId(),
                appointment.getTimeSlotId(), appointment.getPatientId(),appointment.getStatus());
    }
}
