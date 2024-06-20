package eksamen.atletik.api;

import eksamen.atletik.entity.ResultatEntity;
import eksamen.atletik.service.ResultatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultater")
public class ResultatController {
    private final ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping
    public List<ResultatEntity> getResultater(){
        return resultatService.findAll();
    }

    @GetMapping("/{id}")
    public ResultatEntity getResultatById(@PathVariable int id) {
        return resultatService.findById(id);
    }

    @PostMapping
    public ResultatEntity addResultatEntity(@RequestBody ResultatEntity resultatEntity) {
        return resultatService.addResultatEntity(resultatEntity);
    }

    // Resultat POST mapping by Disciplin and Deltager
   /*
    @PostMapping("/deltager/{deltagerId}/disciplin/{disciplinId}")
    public ResultatEntity addResultatForDeltagerAndDisciplin(@PathVariable int deltagerId, @PathVariable int disciplinId, @RequestBody ResultatEntity resultatEntity) {
        return resultatService.addResultatForDeltagerAndDisciplin(deltagerId, disciplinId, resultatEntity);
    } */

    @DeleteMapping("/{id}")
    public void deleteResultatEntity(@PathVariable int id) {
        resultatService.deleteResultatEntity(id);
    }
    @PutMapping("/{id}")
    public ResultatEntity updateResultatEntity(@PathVariable int id, @RequestBody ResultatEntity resultatEntity) {
        return resultatService.updateResultatEntity(id, resultatEntity);
    }
}
