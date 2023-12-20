package org.demointernetshop.mapper;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.user.UserRegistrationAndUpdateRequestDto;
import org.demointernetshop.dto.user.UserResponseDto;
import org.demointernetshop.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class UserMapper {

    private PasswordEncoder passwordEncoder;

    public User mapToUser(UserRegistrationAndUpdateRequestDto userRequestDto) {
        return User.builder()
                .username(userRequestDto.getUsername())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .email(userRequestDto.getEmail())
                .phone(userRequestDto.getPhone())
                .build();
    }

    public UserResponseDto mapToUserResponseDto(User user) {
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
