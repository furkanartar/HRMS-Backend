package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.business.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
    private ImageService imageService;
    private JobSeekerService jobSeekerService;

    @Autowired
    public ImagesController(ImageService imageService, JobSeekerService jobSeekerService) {
        this.imageService = imageService;
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/getAll")
    public DataResult<List<Image>> getAll() {
        return this.imageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
        var jobseeker = this.jobSeekerService.getById(id);

        Image image = new Image();
        image.setJobSeeker(jobseeker.getData());
        this.imageService.add(image, imageFile);
        return new SuccessResult("Eklendi.");
    }

    @PostMapping("/getAllByJobSeekerId")
    public DataResult<List<Image>> getAllByJobSeekerId(@RequestParam int id) {
        return this.imageService.getAllByJobSeekerId(id);
    }
}
