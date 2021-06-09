package io.kodlama.hrms.entities.concretes;

import io.kodlama.hrms.core.utilities.entities.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employee extends User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    @JsonIgnore
//    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}