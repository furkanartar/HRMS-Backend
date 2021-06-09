package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.SchoolInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolInformationDao extends JpaRepository<SchoolInformation, Integer> {
}
