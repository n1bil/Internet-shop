package org.demointernetshop.dto.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Integer id;
    private String username;
    private String role;
    private String email;
    private String phone;
    private LocalDateTime createData;
    private LocalDateTime lastVisitData;

}