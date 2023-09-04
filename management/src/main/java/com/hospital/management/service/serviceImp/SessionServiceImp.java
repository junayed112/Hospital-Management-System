package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.User;
import com.hospital.management.error.PasswordNotMatchedException;
import com.hospital.management.error.TokenNotMatchedException;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.UserRepository;
import com.hospital.management.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionServiceImp implements SessionService {

    @Autowired
    private UserRepository sessionRepository;

    UUID uuid = UUID.randomUUID();

    @Override
    public User login(String name, String password) {
        User user = findByUserName(name);

        if (user == null) {
            throw new UserNotFoundException("Username not found");
        }

        if (user.getPassword().equals(password)) {
            user.setToken(String.valueOf(uuid));
            sessionRepository.save(user);
        }
        else if(!user.getPassword().equals(password)){
            throw new PasswordNotMatchedException("Password doesn't matched");
        }

        return user;
    }

    @Override
    public User resetPassword(String token, String password) {

        User userToken = findByUserToken(token);
        if (userToken == null) {
            throw new TokenNotMatchedException();
        } else {
            if (userToken.getToken().equals(token)) {
                userToken.setPassword(password);
                sessionRepository.save(userToken);
            }
        }

        return userToken;
    }

    @Override
    public User findByUserName(String userName) {
        return sessionRepository.findByUserName(userName);
    }

    @Override
    public User findByUserToken(String token) {
        return sessionRepository.findByToken(token);
    }



}
