package com.hospital.management.service;

import com.hospital.management.entity.Appointment;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    void cancelAppointment(Long id);
}
