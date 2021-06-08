package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsByCompanyDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsOrderByCreatedAt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    @Query("Select new io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsDto"
            +"(e.companyName, p.name, j.numberOfPeopleToBeHired, j.createdAt, j.applicationDeadline)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition p where j.active = true")
    List<ActiveJobAdvertisementsDto> getAllByActive();

    @Query("Select new io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsOrderByCreatedAt"
            +"(e.companyName, p.name, j.numberOfPeopleToBeHired, j.createdAt, j.applicationDeadline)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition p " +
            "where j.active = true " +
            "order by j.createdAt ASC ")
    List<ActiveJobAdvertisementsOrderByCreatedAt> getAllByActiveAndOrderByCreatedAt();

    @Query("Select new io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsByCompanyDto"
            +"(e.companyName, p.name, j.numberOfPeopleToBeHired, j.createdAt, j.applicationDeadline)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition p " +
            "where j.active = true and e.id =:id")
    List<ActiveJobAdvertisementsByCompanyDto> getAllByActiveAndEmployerId(int id);
}