package hieuhung.spring.repo;

import hieuhung.spring.model.EType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ETypeRepo extends CrudRepository<EType, Integer> {}