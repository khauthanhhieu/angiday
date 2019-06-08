package hieuhung.spring.service.impl;

import hieuhung.spring.model.Review;
import hieuhung.spring.repo.ReviewRepo;
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
}