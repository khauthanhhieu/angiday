package hieuhung.spring.service;

import hieuhung.spring.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReview();

    void saveReview(Review review);

    void deleteReview(Integer id);

    Optional<Review> findReviewById(Integer id);

    List<Review> getReviewByEateryId(Integer eateryId);
}