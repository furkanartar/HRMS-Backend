package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.adapter.abstracts.ImageUploadService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
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
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Fotoğraflar listelendi.");
    }

    @Override
    public Result add(Image image, MultipartFile imageFile) {

        @SuppressWarnings("unchecked")
        Map<String, String> uploadPhoto = this.imageUploadService.uploadImageFile(imageFile);

        image.setPhotoPath(uploadPhoto.get("url"));
        this.imageDao.save(image);

        return new SuccessResult("Fotoğraf eklendi.");
    }

    @Override
    public DataResult<List<Image>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<>(this.imageDao.getAllByJobSeekerId(id), "Id'ye göre fotoğraflar listelendi.");
    }
}