package com.hospital.management.service;


import com.hospital.management.entity.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialityService {
    Speciality createSpeciality(Speciality speciality);
    Speciality getSpeciality(Long id);
    Speciality updateSpeciality(Speciality speciality, Long id);

    void DeleteSpeciality (Long id);

//    Speciality deleteById(int id);

}
