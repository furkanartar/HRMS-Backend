package io.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "ending_date")
    private LocalDate endingDate;

    @Column(name = "working_status", nullable = true)
    private boolean workingStatus; // true ise yani devam ediyor ise endingDate boş geçilebilmeli.

    @Column(name = "active")
    private boolean active = true;
}
//Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam ediyor" olarak görüntülenmelidir.