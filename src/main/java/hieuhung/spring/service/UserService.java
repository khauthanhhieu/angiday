package hieuhung.spring.service;

import hieuhung.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public void deleteUser(Integer id);

    public Optional<User> findById(Integer id);
}
