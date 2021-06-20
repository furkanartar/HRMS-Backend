package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.WayOfWorkingService;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wayofworkings")
@CrossOrigin
public class WayOfWorkingsController {
    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WayOfWorkingsController(WayOfWorkingService wayOfWorkingService) {
        this.wayOfWorkingService = wayOfWorkingService;
    }

    @GetMapping("/getAll")
    public List<WayOfWorking> getAll() {
        return this.wayOfWorkingService.getAll();
    }
}
