package io.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Nullable
    //@JsonIgnore
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //@JsonIgnore
    @Nullable
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    //@JsonIgnore
    @Nullable
    @Column(name = "email_authentication_status")
    private boolean emailAuthenticationStatus = false;

    //@JsonIgnore
    @Nullable
    @Column(name = "active")
    private boolean active;
}
