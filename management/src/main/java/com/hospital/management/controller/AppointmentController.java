package com.hospital.management.controller;

import com.hospital.management.dto.mapper.AppointmentMapper;
import com.hospital.management.dto.request.user.AppointmentRequestDto;
import com.hospital.management.dto.response.AppointmentDto;
import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.QueryResponse;
import com.hospital.management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {
    @Autowired
    private static AppointmentMapper appointmentMapper;
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<QueryResponse<String>> bookAppointment(@RequestBody AppointmentRequestDto
                                                                             appointmentRequestDto){
        Appointment appointment = appointmentMapper.toEntity(appointmentRequestDto);
        appointmentService.bookAppointment(appointment);
        QueryResponse<String> response = new QueryResponse<>("Appointment has been fixed",
                true, null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/cancelappointment/{id}")
    public ResponseEntity<QueryResponse<String> > cancelAppointment(@PathVariable Long id){
        appointmentService.cancelAppointment(id);
        QueryResponse<String> response = new QueryResponse<>("Appointment has been canceled",
                true, null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
