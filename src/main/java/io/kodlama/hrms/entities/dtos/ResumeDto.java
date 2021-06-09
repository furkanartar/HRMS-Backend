package io.kodlama.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.kodlama.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResumeDto {
    private JobSeeker jobSeeker;
    private List<Experience> experience;
    private List<Skill> skills;
    private List<Language> languages;
    private List<SocialMedia> socialMedias;
    private List<SchoolInformation> schoolInformations;
    private List<Image> images;
}
