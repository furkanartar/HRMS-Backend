package io.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.kodlama.hrms.core.utilities.entities.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "job_seeker")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Image> images;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<SchoolInformation> schoolInformations;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Image> photos;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Skill> skills;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<SocialMedia> socialMedias;
}