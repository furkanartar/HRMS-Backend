package io.kodlama.hrms.entities.concretes;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employer_id")//
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "jobposition_id")//
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id")//
    private City city;

    @Column(name = "description")//
    private String description;

    @Column(name = "minimum_salary")//
    private double minimumSalary;

    @Column(name = "maximum_salary")//
    private double maximumSalary;

    @Column(name = "number_of_people_to_be_hired")//
    private short numberOfPeopleToBeHired;

    @Column(name = "application_deadline")//
    private LocalDate applicationDeadline;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt = LocalDate.now();

    @Column(name = "active")
    private boolean active = true;
}
