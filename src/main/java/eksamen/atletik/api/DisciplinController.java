package eksamen.atletik.api;

import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.service.DisciplinService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discipliner")
public class DisciplinController {
    private final DisciplinService disciplinService;

    public DisciplinController(DisciplinService disciplinService) {
        this.disciplinService = disciplinService;
    }

    @GetMapping
    public List<DisciplinEntity> getDiscipliner() {
        return disciplinService.findAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DisciplinEntity createDisciplin(DisciplinEntity disciplinEntity) {
        return disciplinService.addDisciplinEntity(disciplinEntity);
    }
}
