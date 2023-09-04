package com.hospital.management.service;

import com.hospital.management.entity.DoctorTimeSlot;
import com.hospital.management.entity.TimeSlot;
import com.hospital.management.entity.User;
import org.aspectj.weaver.ast.Literal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface DoctorTimeSlotService {
    DoctorTimeSlot assignTimeSlot(DoctorTimeSlot doctorTimeSlot);
    List<DoctorTimeSlot> availableTimeSlot(Long id, Date date);
    void deleteDoctorTimeSlot(Long id);
}
