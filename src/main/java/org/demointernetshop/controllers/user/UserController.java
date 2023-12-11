package org.demointernetshop.controllers.user;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.user.UserResponseDto;
import org.demointernetshop.dto.user.UserRegistrationAndUpdateRequestDto;
import org.demointernetshop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegistrationAndUpdateRequestDto request) {
        UserResponseDto savedUser = userService.createUser(request);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRegistrationAndUpdateRequestDto request,
                                                      @PathVariable Integer userId) {
        UserResponseDto updatedUser = userService.updateUser(request, userId);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


}
