package hieuhung.spring.repo;

import hieuhung.spring.model.Eatery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EateryRepo extends CrudRepository<Eatery, Integer> {
    List<Eatery> findByType(Integer type);
}
