package eksamen.atletik.service;

import eksamen.atletik.dto.DisciplinDto;
import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinService {
    private final DisciplinRepository disciplinRepository;
    private final DeltagerRepository deltagerRepository;

    public DisciplinService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }

    public List<DisciplinEntity> findAll() {
        return disciplinRepository.findAll();
    }
    public DisciplinEntity findById(int id){
        return disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
    }
    public DisciplinEntity addDisciplinEntity(DisciplinEntity disciplinDto){
        return disciplinRepository.save(new DisciplinEntity(disciplinDto.getNavn(), disciplinDto.getResultatType()));
    }
    public DisciplinEntity deleteDisciplinEntity(int id) {
        DisciplinEntity disciplinEntity = disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
        disciplinRepository.deleteById(id);
        return disciplinEntity;
    }
    public DisciplinEntity updateDisciplinEntity(int id, DisciplinDto disciplinDto) {
        DisciplinEntity oldDisciplinEntity = disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
        oldDisciplinEntity.setNavn(disciplinDto.getNavn());
        oldDisciplinEntity.setResultatType(disciplinDto.getResultatType());
        return disciplinRepository.save(oldDisciplinEntity);
    }
}
