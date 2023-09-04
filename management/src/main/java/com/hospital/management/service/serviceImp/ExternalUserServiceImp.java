package com.hospital.management.service.serviceImp;

import com.hospital.management.entity.ExternalUser;
import com.hospital.management.error.UserNotFoundException;
import com.hospital.management.repository.ExternalUserRepository;
import com.hospital.management.service.ExternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalUserServiceImp implements ExternalUserService {
    @Autowired
    private ExternalUserRepository externalUserRepository;
    @Override
    public ExternalUser createUser(ExternalUser externalUser) {
        return externalUserRepository.save(externalUser);
    }

    @Override
    public ExternalUser updateUser(ExternalUser externalUser, Long id) {
        Optional<ExternalUser> user = externalUserRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("The user doesn't exist");
        }
        user.get().setName(externalUser.getName());
        user.get().setMobileNo(externalUser.getMobileNo());
        return externalUserRepository.save(user.get());
    }
}
