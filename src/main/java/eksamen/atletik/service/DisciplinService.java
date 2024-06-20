package eksamen.atletik.service;

import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinService {
    public DisciplinService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }
    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

    public List<DisciplinEntity> findAll() {
        return disciplinRepository.findAll();
    }
    public DisciplinEntity findById(int id){
        return disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
    }
    public DisciplinEntity addDisciplinEntity(DisciplinEntity disciplinEntity){
        return disciplinRepository.save(disciplinEntity);
    }
    public DisciplinEntity deleteDisciplinEntity(int id) {
        DisciplinEntity disciplinEntity = disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
        disciplinRepository.deleteById(id);
        return disciplinEntity;
    }
    public DisciplinEntity updateDisciplinEntity(int id, DisciplinEntity disciplinEntity) {
        DisciplinEntity oldDisciplinEntity = disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
        oldDisciplinEntity.setNavn(disciplinEntity.getNavn());
        oldDisciplinEntity.setResultatType(disciplinEntity.getResultatType());
        return disciplinRepository.save(oldDisciplinEntity);
    }
}
