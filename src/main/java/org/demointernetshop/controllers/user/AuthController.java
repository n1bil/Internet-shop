package org.demointernetshop.controllers.user;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.user.AuthRequest;
import org.demointernetshop.dto.user.AuthResponse;
import org.demointernetshop.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        String token = authService.login(authRequest);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(token);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

}
