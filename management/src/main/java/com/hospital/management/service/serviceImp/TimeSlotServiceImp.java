package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.TimeSlot;
import com.hospital.management.error.IdNotFoundException;
import com.hospital.management.repository.TimeSlotRespository;
import com.hospital.management.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSlotServiceImp implements TimeSlotService {

    @Autowired
    private TimeSlotRespository timeSlotRespository;

    @Override
    public TimeSlot createTimeSlot(TimeSlot timeSlotRequest) {
        return timeSlotRespository.save(timeSlotRequest);
    }

    @Override
    public TimeSlot updateTimeSlot(TimeSlot timeSlotRequest, Long id) {
        Optional<TimeSlot> timeSlot = timeSlotRespository.findById(id);
        if (!timeSlot.isPresent()) {
            throw new IdNotFoundException("This id doesn't exist");
        }
        timeSlot.get().setStartTime(timeSlotRequest.getStartTime());
        timeSlot.get().setEndTime(timeSlotRequest.getEndTime());
        return timeSlotRespository.save(timeSlot.get());
    }

    @Override
    public void deleteTimeSlot(Long id) {
        Optional<TimeSlot> timeSlot = timeSlotRespository.findById(id);

        if (!timeSlot.isPresent()) {
            throw new IdNotFoundException("This id doesn't exist");
        }
        timeSlotRespository.delete(timeSlot.get());
    }
}
