package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.User;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.UserRepository;
import com.hospital.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserDetailsById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("Id not found");
        }
        return user.get();
    }

    @Override
    public List<User> findByUserSpeciality(Long id) {
        List<User> list = userRepository.findBySpeciality(id);
        return list;
    }
}
