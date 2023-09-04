package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.DoctorTimeSlot;
import com.hospital.management.entity.TimeSlot;
import com.hospital.management.entity.User;
import com.hospital.management.error.IdNotFoundException;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.DoctorTimeSlotRepository;
import com.hospital.management.repository.TimeSlotRespository;
import com.hospital.management.repository.UserRepository;
import com.hospital.management.service.DoctorTimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class DoctorTimeSlotServiceImp implements DoctorTimeSlotService {
    @Autowired
    private DoctorTimeSlotRepository doctorTimeSlotRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeSlotRespository timeSlotRespository;

    @Override
    public DoctorTimeSlot assignTimeSlot(DoctorTimeSlot doctorTimeSlot) {
        Optional<User> user = userRepository.findById(doctorTimeSlot.getDoctorId());
        if(!user.isPresent()){
            throw new UserNotFoundException("User doesn't exist in the database");
        }
        if(!user.get().getUserType().equals("Doctor")){
            throw new UserNotFoundException("User is not doctor");
        }
        return doctorTimeSlotRepository.save(doctorTimeSlot);
    }

    //    List<User> userList = new ArrayList<>();
//    List<TimeSlot> timeSlotList = new ArrayList<>();
    @Override
    public List<DoctorTimeSlot> availableTimeSlot(Long id, Date date) {
        return doctorTimeSlotRepository.availableSlotByDoctorId(id, date);
    }

    @Override
    public void deleteDoctorTimeSlot(Long id) {
        doctorTimeSlotRepository.deleteById(id);
    }


}
