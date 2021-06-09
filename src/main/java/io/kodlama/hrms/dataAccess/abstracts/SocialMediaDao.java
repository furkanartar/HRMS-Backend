package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
}