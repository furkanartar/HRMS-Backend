package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SchoolInformationService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolinformations")
@CrossOrigin
public class SchoolInformationsController {
    private SchoolInformationService schoolInformationService;

    @Autowired
    public SchoolInformationsController(SchoolInformationService schoolInformationService) {
        this.schoolInformationService = schoolInformationService;
    }

    @PostMapping("/getAll")
    public DataResult<List<SchoolInformation>> getAll() {
        return this.schoolInformationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolInformation schoolInformation) {
        return this.schoolInformationService.add(schoolInformation);
    }
}
