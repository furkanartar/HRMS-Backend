package io.kodlama.hrms.entities.dtos;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobAdvertisementsDto {
    private int id;
    private String companyName;
    private String jobPosition;
    private String City;
    private String WayOfWorking;
    private String description;
    private double minimumSalary;
    private double maximumSalary;
    private short numberOfPeopleToBeHired;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private LocalDate applicationDeadline;
    private boolean active;
    private boolean remote;
    private boolean hrmsAuth;
}