package hieuhung.spring.service.impl;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.repo.EateryRepo;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EateryServiceImpl implements EateryService {
    @Autowired private EateryRepo eateryRepo;

    @Override
    public List<Eatery> getAllEatery() {
        return (List<Eatery>) eateryRepo.findAll();
    }

    @Override
    public void saveEatery(Eatery eatery) {
        eateryRepo.save(eatery);
    }

    @Override
    public void deleteEatery(Integer id) {
        eateryRepo.deleteById(id);
    }

    @Override
    public Optional<Eatery> findEateryById(Integer id) {
        return eateryRepo.findById(id);
    }

    @Override
    public List<Eatery> findEateryByType(Integer type) {
        return eateryRepo.findByType(type);
    }
}
