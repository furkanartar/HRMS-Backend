package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SocialMediaService;
import io.kodlama.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {
    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
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
