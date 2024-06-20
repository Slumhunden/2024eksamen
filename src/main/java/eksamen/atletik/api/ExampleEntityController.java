package eksamen.atletik.api;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exampleEntities")
public class ExampleEntityController {
    private final ExampleEntityService exampleEntityService;

    public ExampleEntityController(ExampleEntityService exampleEntityService) {
        this.exampleEntityService = exampleEntityService;
    }

    //Her kan du lave metoder der bruger service til at hente data fra databasen
    //Du kan også lave metoder der gemmer data i databasen
    //Du kan også lave metoder der sletter data fra databasen
    //Du kan også lave metoder der opdaterer data i databasen

    //Her er et eksempel på en metode der henter alle entities fra databasen
    @GetMapping
    public List<ExampleEntity> getExampleEntities(){
        return exampleEntityService.getExampleEntities();
    }
    //Her er et eksempel på en metode der henter en entity fra databasen ud fra dens ID
    @GetMapping("/{id}")
    public ExampleEntity getExampleEntityById(@PathVariable int id) {
        return exampleEntityService.getExampleEntityById(id);
    }
    //Her er et eksempel på en metode der gemmer en entity i databasen
    @PostMapping
    public ExampleEntity addExampleEntity(@RequestBody ExampleEntity exampleEntity) {
        return exampleEntityService.addExampleEntity(exampleEntity);
    }
    //Her er et eksempel på en metode der sletter en entity fra databasen
    @DeleteMapping("/{id}")
    public void deleteExampleEntity(@PathVariable int id) {
        exampleEntityService.deleteExampleEntity(id);
    }
    //Her er et eksempel på en metode der opdaterer en entity i databasen
    @PutMapping("/{id}")
    public ExampleEntity updateExampleEntity(@PathVariable int id, @RequestBody ExampleEntity exampleEntity) {
        return exampleEntityService.updateExampleEntity(id, exampleEntity);
    }

}
