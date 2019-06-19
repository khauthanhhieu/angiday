package hieuhung.spring.service;


import hieuhung.spring.model.EType;

import java.util.List;
import java.util.Optional;

public interface ETypeService {
    List<EType> getAllEType();

    void saveEType(EType eType);

    void deleteEType(Integer id);

    Optional<EType> findETypeById(Integer id);
}
