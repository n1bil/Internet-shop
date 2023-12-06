package org.demointernetshop.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demointernetshop.entity.Role;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Integer id;
    private String username;
    private Role role;
    private String email;
    private String phoneNumber;

}
