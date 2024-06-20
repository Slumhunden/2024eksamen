package eksamen.atletik.api;

import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.service.DisciplinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
