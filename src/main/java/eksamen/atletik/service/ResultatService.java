package eksamen.atletik.service;

import eksamen.atletik.entity.DeltagerEntity;
import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.entity.ResultatEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import eksamen.atletik.repository.ResultatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ResultatService {
    private final DeltagerRepository deltagerRepository;

    public ResultatService(ResultatRepository resultatRepository, DisciplinRepository disciplinRepository, DeltagerRepository deltagerRepository){
    this.resultatRepository = resultatRepository;
    this.disciplinRepository = disciplinRepository;
        this.deltagerRepository = deltagerRepository;
    }
    private final DisciplinRepository disciplinRepository;
    private final ResultatRepository resultatRepository;

    public List<ResultatEntity> findAll() {
        return resultatRepository.findAll();
    }
    public ResultatEntity findById(int id) {
        return resultatRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resultat not found"));
    }
    public ResultatEntity addResultatEntity(ResultatEntity resultatEntity){
        return resultatRepository.save(resultatEntity);
    }
    public void deleteResultatEntity(int id) {
        resultatRepository.deleteById(id);
    }


    public ResultatEntity updateResultatEntity(int id, ResultatEntity resultatEntity) {
        ResultatEntity oldResultatEntity = resultatRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resultat not found"));
        oldResultatEntity.setDisciplin(resultatEntity.getDisciplin());
        oldResultatEntity.setTid(resultatEntity.getTid());
        return resultatRepository.save(oldResultatEntity);

    }
}
