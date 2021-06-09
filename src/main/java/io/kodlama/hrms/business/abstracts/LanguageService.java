package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.*;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    boolean add(Language language);
}