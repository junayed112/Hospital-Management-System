package com.hospital.management.dto.mapper;

import com.hospital.management.dto.request.user.UserRequestDto;
import com.hospital.management.dto.response.UserDto;
import com.hospital.management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUserName(), user.getUserType(), user.getEmail(), user.getMobile(),
                user.getDateOfBirth(), user.getToken(), user.getSpeciality(), user.getTimeSlot());
    }

    public User toUser(UserRequestDto userDto) {
        return new User(userDto.getName(),
                userDto.getType(),
                userDto.getEmail(),
                userDto.getMobile(),
                userDto.getPassword(),
                userDto.getDateOfBirth(),
                null,
                null,null);
    }
}
