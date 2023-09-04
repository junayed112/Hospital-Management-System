package com.hospital.management.repository;

import com.hospital.management.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRespository extends JpaRepository<TimeSlot, Long> {
}
