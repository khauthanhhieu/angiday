package hieuhung.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findByTitle(String title);
}