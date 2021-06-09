package io.kodlama.hrms.entities.concretes;

import io.kodlama.hrms.core.utilities.entities.User;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;
}
