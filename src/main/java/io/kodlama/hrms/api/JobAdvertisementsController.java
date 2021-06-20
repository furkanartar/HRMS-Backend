package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsByCompanyDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsOrderByCreatedAt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public List<JobAdvertisement> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getAllByActive")
    public List<ActiveJobAdvertisementsDto> getAllByActive()
    {
        return this.jobAdvertisementService.getAllByActive();
    }

    @GetMapping("/getAllByActiveOrderByCreatedAt")
    public List<ActiveJobAdvertisementsOrderByCreatedAt> getAllByActiveOrderByCreatedAt()
    {
        return this.jobAdvertisementService.getAllByActiveAndOrderByCreatedAt();
    }

    @GetMapping("/getAllByActiveAndEmployerId")
    public List<ActiveJobAdvertisementsByCompanyDto> getAllByActiveAndEmployerId(@RequestParam int id)
    {
        return this.jobAdvertisementService.getAllByActiveAndEmployerId(id);
    }

    @GetMapping("/closeJobAdvertisment")
    public boolean closeJobAdvertisment(@RequestParam int jobAdvertismentId)
    {
        return this.jobAdvertisementService.closeJobAdvertisment(jobAdvertismentId);
    }

    @GetMapping("/getAllByActiveAndJobPositionId")
    public List<JobAdvertisement> getAllByActiveAndJobPositionId(@RequestParam int id)
    {
        return this.jobAdvertisementService.findAllByJobPositionId(id);
    }
}