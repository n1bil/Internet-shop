package org.demointernetshop.mapper;

import org.demointernetshop.dto.user.UserRegistrationAndUpdateRequestDto;
import org.demointernetshop.dto.user.UserResponseDto;
import org.demointernetshop.entity.User;

public class UserMapper {

    public User mapToUser(UserRegistrationAndUpdateRequestDto userRequestDto) {
        return User.builder()
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .phone(userRequestDto.getPhone())
                .build();
    }

    public UserResponseDto mapToUserResponseDtp(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createData(user.getCreateData())
                .lastVisitData(user.getLastVisitData())
                .build();
    }
}
