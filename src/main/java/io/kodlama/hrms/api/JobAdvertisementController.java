//package io.kodlama.hrms.api;
//
//import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
//import io.kodlama.hrms.entities.concretes.JobAdvertisement;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/jobadvertisements")
//public class JobAdvertisementController {
//    private JobAdvertisementService jobAdvertisementService;
//
//    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
//        this.jobAdvertisementService = jobAdvertisementService;
//    }
//
//    @GetMapping("/getall")
//    public List<JobAdvertisement> getAll(){
//        return this.jobAdvertisementService.getAll();
//    }
//}