package com.hospital.management.repository;

import com.hospital.management.dto.response.AppointmentDto;
import com.hospital.management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
