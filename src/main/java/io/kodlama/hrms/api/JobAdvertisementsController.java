package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getAllByActive")
    public DataResult<List<JobAdvertisementsDto>> getAllByActive()
    {
        return this.jobAdvertisementService.getAllByActive();
    }

    @GetMapping("/getAllByActiveOrderByCreatedAt")
    public DataResult<List<JobAdvertisementsDto>> getAllByActiveOrderByCreatedAt()
    {
        return this.jobAdvertisementService.getAllByActiveAndOrderByCreatedAt();
    }

    @GetMapping("/getAllByActiveAndEmployerId")
    public DataResult<List<JobAdvertisementsDto>> getAllByActiveAndEmployerId(@RequestParam int id)
    {
        return this.jobAdvertisementService.getAllByActiveAndEmployerId(id);
    }

    @GetMapping("/closeJobAdvertisment")
    public Result closeJobAdvertisment(@RequestParam int jobAdvertismentId)
    {
        return this.jobAdvertisementService.closeJobAdvertisment(jobAdvertismentId);
    }

    @GetMapping("/getAllByActiveAndJobPositionId")
    public DataResult<List<JobAdvertisementsDto>> getAllByActiveAndJobPositionId(@RequestParam int id)
    {
        return this.jobAdvertisementService.getAllByJobPositionId(id);
    }
}