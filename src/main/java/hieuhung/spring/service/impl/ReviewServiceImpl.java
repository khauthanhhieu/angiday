package hieuhung.spring.service.impl;

import hieuhung.spring.model.Image;
import hieuhung.spring.model.Eatery;
import hieuhung.spring.model.Review;
import hieuhung.spring.repo.EateryRepo;
import hieuhung.spring.repo.ReviewRepo;
import hieuhung.spring.service.ImageService;
import hieuhung.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private EateryRepo eateryRepo;

    @Autowired
    private ImageService imageService;

    @Override
    public List<Review> getAllReview() {
        return (List<Review>) reviewRepo.findAll();
    }

    @Override
    public void saveReview(Review review) {
        LocalDateTime dateTime = LocalDateTime.now();

        Date date = Date.valueOf(dateTime.toLocalDate());
        Time time = Time.valueOf(dateTime.toLocalTime());

        String content = review.getContent().replace("\n", "<br>");
        review.setContent(content);
        review.setDate(date);
        review.setTime(time);

        Eatery eatery = eateryRepo.findById(review.getIdEatery()).get();
        int n = reviewRepo.getReviewByEateryId(review.getIdEatery()).size();
        float sumPoint = n * eatery.getPoint();
        eatery.setPoint((sumPoint + review.getPoint()) / (n + 1));

        eateryRepo.save(eatery);
        reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Optional<Review> findReviewById(Integer id) {
        return reviewRepo.findById(id);
    }

    @Override
    public List<Review> getReviewByEateryId(Integer eateryId) {
        List<Review> reviews = reviewRepo.getReviewByEateryId(eateryId);

        for (Review review : reviews) {
            Image reviewImage = imageService.findImageById(review.getImage()).get();
            review.setReviewImage(reviewImage.getImage());
        }

        return reviews;
    }

    @Override
    public List<Review> getReviewByUserId(Integer id) {
        return reviewRepo.findByIdUser(id);
    }
}