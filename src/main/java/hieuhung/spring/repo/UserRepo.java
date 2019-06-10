package hieuhung.spring.repo;

import hieuhung.spring.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameOrEmail(String username, String email);
}