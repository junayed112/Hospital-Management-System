package com.hospital.management.service;

import com.hospital.management.entity.ExternalUser;
import org.springframework.stereotype.Service;

@Service
public interface ExternalUserService {
    ExternalUser createUser(ExternalUser externalUser);
    ExternalUser updateUser(ExternalUser externalUser, Long id);
}
