package io.kodlama.hrms.core.utilities.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Nullable
    private int id;

    //@Email
    //@NotBlank
    //@NotNull
    @Column(name = "email")
    private String email;

    //@NotBlank
    //@NotNull
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Nullable
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    @Nullable
    @Column(name = "email_authentication_status")
    private boolean emailAuthenticationStatus = false; //hrms auth lazım

    @JsonIgnore
    @Nullable
    @Column(name = "active")
    private boolean active = false; //email auth lazım
}
