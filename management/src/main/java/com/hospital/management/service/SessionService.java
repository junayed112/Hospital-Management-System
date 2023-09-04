package com.hospital.management.service;

import com.hospital.management.entity.User;
import com.hospital.management.error.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    User login(String name, String password) throws UserNotFoundException;
    User resetPassword(String token, String password);
    User findByUserName(String userName);
    User findByUserToken(String token);

}
