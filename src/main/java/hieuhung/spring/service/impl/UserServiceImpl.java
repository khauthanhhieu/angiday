package hieuhung.spring.service.impl;

import hieuhung.spring.model.User;
import hieuhung.spring.repo.UserRepo;
import hieuhung.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void saveUser(User user){
        String passEncoder = passwordEncoder.encode(user.getPassword());
        user.setPassword(passEncoder);

        userRepo.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
}
