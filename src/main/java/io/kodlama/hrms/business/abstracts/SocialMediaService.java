package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.SocialMedia;

import java.util.List;

public interface SocialMediaService {
    List<SocialMedia> getAll();
    boolean add(SocialMedia socialMedia);
}
