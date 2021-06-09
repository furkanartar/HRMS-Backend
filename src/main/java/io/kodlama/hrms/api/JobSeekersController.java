package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.dtos.ResumeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobsekeer")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    public JobSeekersController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public List<JobSeeker> getAll(){
        return this.jobSeekerService.getAll();
    }

    @GetMapping("/getJobSeekerResumeById")
    public ResumeDto getJobSeekerResumeById(int id){
        return this.jobSeekerService.getJobSeekerResumeById(id);
    }
}
