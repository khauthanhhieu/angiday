package hieuhung.spring.service.impl;

import hieuhung.spring.model.EType;
import hieuhung.spring.repo.ETypeRepo;
import hieuhung.spring.service.ETypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ETypeServiceImpl implements ETypeService {
    @Autowired private ETypeRepo eTypeRepo;

    @Override
    public List<EType> getAllEType() {
        return (List<EType>) eTypeRepo.findAll();
    }

    @Override
    public void saveEType(EType eType) {
        eTypeRepo.save(eType);
    }

    @Override
    public void deleteEType(Integer id) {
        eTypeRepo.deleteById(id);
    }

    @Override
    public Optional<EType> findETypeById(Integer id) {
        return eTypeRepo.findById(id);
    }
}
