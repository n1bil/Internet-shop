package org.demointernetshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne(mappedBy = "user")
    private Cart cart;
    @CreationTimestamp
    private LocalDateTime createData;
    @UpdateTimestamp
    private LocalDateTime lastVisitData;
}
