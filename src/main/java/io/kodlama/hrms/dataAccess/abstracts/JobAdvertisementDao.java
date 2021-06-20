package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    @Query("Select new io.kodlama.hrms.entities.dtos.JobAdvertisementsDto"
            +"( j.id, e.companyName, position.name, c.name, w.name, j.description, j.minimumSalary, j.maximumSalary, j.numberOfPeopleToBeHired, " +
            "j.createdAt, j.lastModifiedAt, j.applicationDeadline, j.active, j.remote, j.hrmsAuth)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition position inner join j.city c inner join j.wayOfWorking w " +
            "where j.active = true and j.hrmsAuth = true")
    List<JobAdvertisementsDto>  getAllByActive();

    @Query("Select new io.kodlama.hrms.entities.dtos.JobAdvertisementsDto"
            +"( j.id, e.companyName, position.name, c.name, w.name, j.description, j.minimumSalary, j.maximumSalary, j.numberOfPeopleToBeHired, " +
            "j.createdAt, j.lastModifiedAt, j.applicationDeadline, j.active, j.remote, j.hrmsAuth)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition position inner join j.city c inner join j.wayOfWorking w " +
            "where j.active = true and j.hrmsAuth = true order by j.createdAt ASC ")
    List<JobAdvertisementsDto> getAllByActiveAndOrderByCreatedAt();

    @Query("Select new io.kodlama.hrms.entities.dtos.JobAdvertisementsDto"
            +"( j.id, e.companyName, position.name, c.name, w.name, j.description, j.minimumSalary, j.maximumSalary, j.numberOfPeopleToBeHired, " +
            "j.createdAt, j.lastModifiedAt, j.applicationDeadline, j.active, j.remote, j.hrmsAuth)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition position inner join j.city c inner join j.wayOfWorking w " +
            "where j.active = true and j.hrmsAuth = true and e.id =:id")
    List<JobAdvertisementsDto> getAllByActiveAndEmployerId(int id);

    @Query("Select new io.kodlama.hrms.entities.dtos.JobAdvertisementsDto"
            +"( j.id, e.companyName, position.name, c.name, w.name, j.description, j.minimumSalary, j.maximumSalary, j.numberOfPeopleToBeHired, " +
            "j.createdAt, j.lastModifiedAt, j.applicationDeadline, j.active, j.remote, j.hrmsAuth)"
            +"From JobAdvertisement j Inner Join j.employer e inner join j.jobPosition position inner join j.city c inner join j.wayOfWorking w " +
            "where j.active = true and j.hrmsAuth = true and position.id =:id")
    List<JobAdvertisementsDto> getAllByJobPositionId(int id);
}