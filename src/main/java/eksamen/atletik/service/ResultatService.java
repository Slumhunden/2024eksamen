package eksamen.atletik.service;

import eksamen.atletik.entity.ResultatEntity;
import eksamen.atletik.repository.ResultatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ResultatService {
    public ResultatService(ResultatRepository resultatRepository) {
    this.resultatRepository = resultatRepository;
    }
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
