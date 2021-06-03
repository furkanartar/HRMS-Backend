package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.JobPositionService;
import io.kodlama.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/jobpositions"})
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping({"/getall"})
    public List<JobPosition> getAll() {
        return this.jobPositionService.getAll();
    }

    @PostMapping({"/add"})
    public boolean add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }
}
