package io.kodlama.hrms.core.utilities.adapter.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.kodlama.hrms.core.utilities.adapter.abstracts.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadAdapter implements ImageUploadService {
    private Cloudinary cloudinary;

    @Autowired
    public ImageUploadAdapter(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "asosyal01",
                "api_key", "494981687638566",
                "api_secret", "k_3ySNokgf6Pg2Il86j40ABqkI4"));

        this.cloudinary = cloudinary;
    }


    @Override
    public Map uploadImageFile(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return resultMap;
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
