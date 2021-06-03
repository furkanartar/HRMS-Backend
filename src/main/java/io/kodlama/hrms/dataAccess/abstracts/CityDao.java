package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {

}
