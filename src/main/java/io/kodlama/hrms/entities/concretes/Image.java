package io.kodlama.hrms.entities.concretes;

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
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @Column(name = "image_path") //Cloudinary.com
    private String photoPath;

    @Column(name = "active")
    private boolean active = true;
}
