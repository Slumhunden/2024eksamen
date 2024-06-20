package eksamen.atletik.api;

import eksamen.atletik.dto.DisciplinDto;
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
    @PostMapping
    public DisciplinEntity createDisciplin(@RequestBody DisciplinDto disciplinDto) {
        return disciplinService.addDisciplinEntity(new DisciplinEntity(disciplinDto.getNavn(), disciplinDto.getResultatType()));
    }
}
