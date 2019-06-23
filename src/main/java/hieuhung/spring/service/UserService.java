package hieuhung.spring.service;

import hieuhung.spring.model.Review;
import hieuhung.spring.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Integer id);

    Optional<User> findById(Integer id);

    User findByUsername(String username);

    List<User> getUserReviews(List<Review> reviewList);
}
