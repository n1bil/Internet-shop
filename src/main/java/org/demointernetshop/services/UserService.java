package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.user.UserRegistrationAndUpdateRequestDto;
import org.demointernetshop.dto.user.UserResponseDto;
import org.demointernetshop.entity.Role;
import org.demointernetshop.entity.User;
import org.demointernetshop.exception.NotFoundException;
import org.demointernetshop.mapper.UserMapper;
import org.demointernetshop.repository.RoleRepository;
import org.demointernetshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private RoleRepository roleRepository;

    public UserResponseDto createUser(UserRegistrationAndUpdateRequestDto request) {
        User user = userMapper.mapToUser(request);

        Role userRole = roleRepository.findById(2).get();
        user.setRole(userRole);
        User savedUser = userRepository.save(user);

        return userMapper.mapToUserResponseDto(savedUser);
    }

    public UserResponseDto updateUser(UserRegistrationAndUpdateRequestDto request, Integer userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
        foundUser.setUsername(request.getUsername());
        foundUser.setPassword(request.getPassword());
        foundUser.setEmail(request.getEmail());
        foundUser.setPhone(request.getPhone());


        User updatedUser = userRepository.save(foundUser);

        return userMapper.mapToUserResponseDto(updatedUser);
    }

}
