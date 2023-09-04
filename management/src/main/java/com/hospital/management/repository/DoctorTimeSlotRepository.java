package com.hospital.management.repository;

import com.hospital.management.entity.DoctorTimeSlot;
import com.hospital.management.service.DoctorTimeSlotService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DoctorTimeSlotRepository extends JpaRepository<DoctorTimeSlot, Long> {

    @Query(value = "Select * from doctor_time_slot a where a.doctor_id=?1 AND a.date=?2" +
            " AND a.appointment_booked='No' ", nativeQuery = true)
    List<DoctorTimeSlot> availableSlotByDoctorId(Long id, Date date);

    @Query(value = "Select * from doctor_time_slot a where a.doctor_id=?1 AND a.time_slot_id=?2" +
            " AND a.date=?3", nativeQuery = true)
    DoctorTimeSlot findDoctorIdByTimeSlot(Long doctorId, Long timeSlotId, Date date);

}
