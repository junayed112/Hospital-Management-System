package com.hospital.management.service;

import com.hospital.management.entity.TimeSlot;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Service;

@Service
public interface TimeSlotService {
    TimeSlot createTimeSlot(TimeSlot timeSlot);

    TimeSlot updateTimeSlot(TimeSlot timeSlot, Long id);

    void deleteTimeSlot(Long id);
}
