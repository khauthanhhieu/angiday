package hieuhung.spring.repo;

import hieuhung.spring.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    @Query(value = "select * from reviews where id_eatery = :eateryId", nativeQuery = true)
    List<Review> getReviewByEateryId(@Param("eateryId") Integer eateryId);

    List<Review> findByIdUser(Integer id);
}