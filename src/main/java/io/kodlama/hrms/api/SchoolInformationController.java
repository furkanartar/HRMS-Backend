package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SchoolInformationService;
import io.kodlama.hrms.entities.concretes.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schoolInformations")
public class SchoolInformationController {
    private SchoolInformationService schoolInformationService;

    @Autowired
    public SchoolInformationController(SchoolInformationService schoolInformationService) {
        this.schoolInformationService = schoolInformationService;
    }

    @PostMapping("/getAll")
    public List<SchoolInformation> getAll() {
        return this.schoolInformationService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody SchoolInformation schoolInformation) {
        return this.schoolInformationService.add(schoolInformation);
    }
}
