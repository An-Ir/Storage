package com.example.storage.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;


    public void saveImage(Image image) {
        imageRepository.save(image);
    }
}
