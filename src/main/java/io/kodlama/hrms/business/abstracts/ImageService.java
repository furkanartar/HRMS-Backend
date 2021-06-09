package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getAll();
    boolean add(Image image, MultipartFile imageFile);
    List<Image> getAllByJobSeekerId(int id);
}
