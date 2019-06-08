package hieuhung.spring.service;

import hieuhung.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public void saveUser(User user);

    public void deleteUser(User user);

    public Optional<User> findById(Integer id);
}
