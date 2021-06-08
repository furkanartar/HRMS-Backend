package io.kodlama.hrms.entities.dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiveJobAdvertisementsDto {
    private String companyName;
    private String jobPosition;
    private short numberOfPeopleToBeHired;
    private LocalDate createdAt;
    private LocalDate applicationDeadline;
}