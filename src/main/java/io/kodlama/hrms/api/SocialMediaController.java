package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SocialMediaService;
import io.kodlama.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedias")
public class SocialMediaController {
    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("/getAll")
    public List<SocialMedia> getAll() {
        return this.socialMediaService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody SocialMedia socialMedia) {
        return this.socialMediaService.add(socialMedia);
    }
}
