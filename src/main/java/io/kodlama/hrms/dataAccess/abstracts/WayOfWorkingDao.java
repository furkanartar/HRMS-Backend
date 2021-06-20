package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.WayOfWorking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer> {
}
