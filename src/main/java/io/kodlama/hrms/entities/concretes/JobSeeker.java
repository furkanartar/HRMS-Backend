package io.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "job_seeker")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private LocalDate birthDate;

//hata olursa alttaki satırı aç
//    public JobSeeker(int id, String email, String password, LocalDate createdAt, boolean emailAuthenticationStatus, boolean active, int id1, String firstName, String lastName, String nationalIdentity, LocalDate birthDate) {
//        super(id, email, password, createdAt, emailAuthenticationStatus, active);
//        this.id = id1;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.nationalIdentity = nationalIdentity;
//        this.birthDate = birthDate;
//    }
}