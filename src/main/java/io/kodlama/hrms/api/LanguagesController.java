package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.LanguageService;
import io.kodlama.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/languages"})
@CrossOrigin
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/getAll")
    public List<Language> getAll() {
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Language language) {
        return this.languageService.add(language);
    }
}
