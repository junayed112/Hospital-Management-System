package com.hospital.management.service;

import com.hospital.management.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreationService {
    User registration(User user, Long specialityId);
    User findByUserType(String usertype);
}
