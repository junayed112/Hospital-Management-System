package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.Speciality;
import com.hospital.management.error.SpecialityNotFoundException;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.SpecialityRepository;
import com.hospital.management.repository.UserRepository;
import com.hospital.management.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialityServiceImp implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality getSpeciality(Long id) {
        return specialityRepository.findById(id).get();
    }

    @Override
    public Speciality updateSpeciality(Speciality specialityRequest, Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        if (!speciality.isPresent()) {
            throw new SpecialityNotFoundException("This id isn't present");
        }

        speciality.get().setName(specialityRequest.getName());

        return specialityRepository.save(speciality.get());
    }

    @Override
    public void DeleteSpeciality(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        if (!speciality.isPresent()) {
            throw new SpecialityNotFoundException("The id doesn't exist");
        }

        specialityRepository.deleteById(speciality.get().getId());
    }

}
