package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
    private int id;
    private String companyName;
    private String webSite;
    private String email;
    private String phoneNumber;
    private String password;
    private String passwordAgain;
}