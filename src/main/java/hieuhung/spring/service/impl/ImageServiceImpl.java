package hieuhung.spring.service.impl;

import hieuhung.spring.model.Image;
import hieuhung.spring.repo.ImageRepo;
import hieuhung.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepo imageRepo;

    @Override
    public List<Image> getAllImage() {
        return (List<Image>)imageRepo.findAll();
    }

    @Override
    public void saveImage(Image image) {
        imageRepo.save(image);
    }

    @Override
    public void deleteImage(Integer id) {
        imageRepo.findById(id);
    }

    @Override
    public Optional<Image> findImageById(Integer id) {
        return imageRepo.findById(id);
    }
}
