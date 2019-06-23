package hieuhung.spring.service;

import hieuhung.spring.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    List<Image> getAllImage();
    void saveImage(Image image);
    void deleteImage(Integer id);
    Optional<Image> findImageById(Integer id);
}
