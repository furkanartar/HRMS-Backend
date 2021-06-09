package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.adapter.abstracts.ImageUploadService;
import io.kodlama.hrms.dataAccess.abstracts.ImageDao;
import io.kodlama.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private ImageUploadService imageUploadService;

    @Autowired
    public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
        this.imageDao = imageDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public List<Image> getAll() {
        return this.imageDao.findAll();
    }

    @Override
    public boolean add(Image image, MultipartFile imageFile) {

        @SuppressWarnings("unchecked")
        Map<String, String> uploadPhoto = this.imageUploadService.uploadImageFile(imageFile);

        image.setPhotoPath(uploadPhoto.get("url"));
        this.imageDao.save(image);

        return true;
    }

    @Override
    public List<Image> getAllByJobSeekerId(int id) {
        return this.imageDao.getAllByJobSeekerId(id);
    }
}