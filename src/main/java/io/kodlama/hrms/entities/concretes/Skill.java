package io.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @Column(name = "skill")
    private String skill;//bilinen dil, kütüphane vs.

    @JsonIgnore
    @Column(name = "active")
    private boolean active = true;
}
