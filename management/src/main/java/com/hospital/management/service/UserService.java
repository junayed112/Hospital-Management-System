package com.hospital.management.service;

import com.hospital.management.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserDetailsById(Long id);
    List<User> findByUserSpeciality(Long id);
}
