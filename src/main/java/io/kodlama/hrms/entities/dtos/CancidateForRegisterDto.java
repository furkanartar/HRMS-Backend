package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancidateForRegisterDto {
    private int id;
    private String name;
    private String lastName;
    private String nationalIdentity;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String passwordAgain;
}