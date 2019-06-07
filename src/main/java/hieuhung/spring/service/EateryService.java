package hieuhung.spring.service;

import hieuhung.spring.model.Eatery;

import java.util.List;
import java.util.Optional;

public interface EateryService {
    List<Eatery> getAllEatery();

    void saveEatery(Eatery eatery);

    void deleteEatery(Integer id);

    Optional<Eatery> findEateryById(Integer id);
}
