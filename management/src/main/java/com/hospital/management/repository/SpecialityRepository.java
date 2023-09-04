package com.hospital.management.repository;

import com.hospital.management.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
