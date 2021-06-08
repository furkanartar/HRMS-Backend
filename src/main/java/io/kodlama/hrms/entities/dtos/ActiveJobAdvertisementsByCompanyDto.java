package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiveJobAdvertisementsByCompanyDto {
    private String companyName;
    private String jobPosition;
    private short numberOfPeopleToBeHired;
    private LocalDate createdAt;
    private LocalDate applicationDeadline;
}
