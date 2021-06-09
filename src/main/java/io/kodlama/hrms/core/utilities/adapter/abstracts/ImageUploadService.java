package io.kodlama.hrms.core.utilities.adapter.abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {
    Map uploadImageFile(MultipartFile imageFile);
}
