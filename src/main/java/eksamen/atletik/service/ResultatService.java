package eksamen.atletik.service;

import eksamen.atletik.dto.ResultatDto;
import eksamen.atletik.entity.DeltagerEntity;
import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.entity.ResultatEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import eksamen.atletik.repository.ResultatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
    private final ResultatRepository resultatRepository;
    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

    public ResultatService(ResultatRepository resultatRepository, DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.resultatRepository = resultatRepository;
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }

    public List<ResultatEntity> findAll() {
        return resultatRepository.findAll();
    }

    public ResultatEntity findById(int id) {
        return resultatRepository.findById(id).orElseThrow(() -> new RuntimeException("Resultat not found"));
    }

    public ResultatEntity addResultatEntity(ResultatDto resultatDto) {
        DeltagerEntity deltager = deltagerRepository.findById(resultatDto.getDeltagerId())
                .orElseThrow(() -> new RuntimeException("Deltager not found"));
        DisciplinEntity disciplin = disciplinRepository.findById(resultatDto.getDisciplinId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found"));

        ResultatEntity resultatEntity = new ResultatEntity(
                resultatDto.getResultat(),
                resultatDto.getDato(),
                resultatDto.getScore(),
                deltager,
                disciplin
        );

        return resultatRepository.save(resultatEntity);
    }

    public ResultatEntity updateResultatEntity(int id, ResultatDto resultatDto) {
        ResultatEntity existingResultat = findById(id);
        DeltagerEntity deltager = deltagerRepository.findById(resultatDto.getDeltagerId())
                .orElseThrow(() -> new RuntimeException("Deltager not found"));
        DisciplinEntity disciplin = disciplinRepository.findById(resultatDto.getDisciplinId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found"));

        existingResultat.setResultat(resultatDto.getResultat());
        existingResultat.setDato(resultatDto.getDato());
        existingResultat.setScore(resultatDto.getScore());
        existingResultat.setDeltager(deltager);
        existingResultat.setDisciplin(disciplin);

        return resultatRepository.save(existingResultat);
    }

    public void deleteResultatEntity(int id) {
        resultatRepository.deleteById(id);
    }

    public ResultatEntity updateResultatForDeltager(int deltagerId, int resultatId, ResultatDto resultatDto) {
        DeltagerEntity deltager = deltagerRepository.findById(deltagerId).orElseThrow(() -> new RuntimeException("Deltager not found"));
        ResultatEntity existingResultat = findById(resultatId);
        if (existingResultat.getDeltager().getId() != deltagerId) {
            throw new RuntimeException("Resultat does not belong to the specified Deltager");
        }
        DisciplinEntity disciplin = disciplinRepository.findById(resultatDto.getDisciplinId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found"));

        existingResultat.setResultat(resultatDto.getResultat());
        existingResultat.setDato(resultatDto.getDato());
        existingResultat.setScore(resultatDto.getScore());
        existingResultat.setDisciplin(disciplin);

        return resultatRepository.save(existingResultat);
    }

    public void deleteResultatForDeltager(int deltagerId, int resultatId) {
        DeltagerEntity deltager = deltagerRepository.findById(deltagerId).orElseThrow(() -> new RuntimeException("Deltager not found"));
        ResultatEntity existingResultat = findById(resultatId);
        if (existingResultat.getDeltager().getId() != deltagerId) {
            throw new RuntimeException("Resultat does not belong to the specified Deltager");
        }
        resultatRepository.deleteById(resultatId);
    }
}
