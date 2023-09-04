package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.Speciality;
import com.hospital.management.entity.TimeSlot;
import com.hospital.management.entity.User;
import com.hospital.management.error.SpecialityNotFoundException;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.SpecialityRepository;
import com.hospital.management.repository.TimeSlotRespository;
import com.hospital.management.repository.UserRepository;
import com.hospital.management.service.CreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreationServiceImp implements CreationService {

    @Autowired
    private UserRepository creationRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private TimeSlotRespository timeSlotRespository;

    List<User> userList = new ArrayList<>();

    @Override
    public User registration(User user, Long specialityId) {
        if (!user.getUserType().equals("Doctor")) {
            user.setSpeciality(null);
            user.setTimeSlot(null);
            return creationRepository.save(user);
        }

        Optional<Speciality> speciality = specialityRepository.findById(specialityId);
        if (!speciality.isPresent()) {
            throw new SpecialityNotFoundException("This speciality isn't present here");
        }

        user.setSpeciality(speciality.get());
        return creationRepository.save(user);
    }

    @Override
    public User findByUserType(String usertype) {
        return creationRepository.findByUserType(usertype);
    }

}
