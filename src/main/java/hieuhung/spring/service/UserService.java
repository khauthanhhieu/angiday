package hieuhung.spring.service;

import hieuhung.spring.model.User;
import hieuhung.spring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
}
