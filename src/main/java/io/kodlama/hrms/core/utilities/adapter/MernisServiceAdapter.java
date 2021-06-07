package io.kodlama.hrms.core.utilities.adapter;

import io.kodlama.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MernisServiceAdapter implements MernisService{

    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return true;
    }
}
