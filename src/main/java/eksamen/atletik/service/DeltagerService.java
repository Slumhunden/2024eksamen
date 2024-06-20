package eksamen.atletik.service;

import eksamen.atletik.entity.DeltagerEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeltagerService {
    @Autowired
    public DeltagerService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;

    }
    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

    public List<DeltagerEntity> findAll() {
        return deltagerRepository.findAll();
    }
    public DeltagerEntity findById(int id){
        return deltagerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deltager not found"));
    }

    public DeltagerEntity addDeltagerEntity(DeltagerEntity deltagerEntity) {
        return deltagerRepository.save(deltagerEntity);
    }
    public void deleteDeltagerEntity(int id) {
        deltagerRepository.deleteById(id);
    }
    public DeltagerEntity updateDeltagerEntity(int id, DeltagerEntity deltagerEntity) {
        DeltagerEntity oldDeltagerEntity = deltagerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deltager not found"));
        oldDeltagerEntity.setNavn(deltagerEntity.getNavn());
        oldDeltagerEntity.setKlub(deltagerEntity.getKlub());
        oldDeltagerEntity.setGender(deltagerEntity.getGender());
        oldDeltagerEntity.setAlder(deltagerEntity.getAlder());
        return deltagerRepository.save(oldDeltagerEntity);
    }
}
