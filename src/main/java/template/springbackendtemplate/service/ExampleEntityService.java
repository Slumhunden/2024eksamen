package template.springbackendtemplate.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import template.springbackendtemplate.entity.ExampleEntity;
import template.springbackendtemplate.repository.ExampleEntityRepository;

import java.util.List;


@Service
public class ExampleEntityService {

    //Vi laver vores repository final da det skal det samme igennem hele klassen
    public ExampleEntityService(ExampleEntityRepository exampleEntityRepository) {
        this.exampleEntityRepository = exampleEntityRepository;
    }
    //Vi bruger constructor injection til at injecte vores repository så vi kan bruge den i hele klassen
    private final ExampleEntityRepository exampleEntityRepository;


    /*
    Her kan du lave betoder der bruger repository til at hente data fra databasen
    Du kan også lave metoder der gemmer data i databasen
    Du kan også lave metoder der sletter data fra databasen
    Du kan også lave metoder der opdaterer data i databasen
     */

    //Her er et eksempel på en metode der henter alle entities fra databasen

    public List<ExampleEntity> getExampleEntities(){
        return exampleEntityRepository.findAll();
    }

    //Her er et eksempel på en metode der henter en entity fra databasen ud fra dens ID
    public ExampleEntity getExampleEntityById(int id) {
        return exampleEntityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ExampleEntity not found"));
        //Hvis entityen ikke findes i databasen kastes en exception med status NOT_FOUND
    }
    //Her er et eksempel på en metode der gemmer en entity i databasen
    public ExampleEntity addExampleEntity(ExampleEntity exampleEntity) {
        return exampleEntityRepository.save(exampleEntity);
    }
    //Her er et eksempel på en metode der sletter en entity fra databasen
    public void deleteExampleEntity(int id) {
        exampleEntityRepository.deleteById(id);
    }
    //Her er et eksempel på en metode der opdaterer en entity i databasen
    public ExampleEntity updateExampleEntity(int id, ExampleEntity exampleEntity) {
        //Hent entity fra databasen
        ExampleEntity oldExampleEntity = exampleEntityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ExampleEntity not found"));
        //Opdater entityen med de nye værdier
        oldExampleEntity.setName(exampleEntity.getName());
        //Gem entityen i databasen
        return exampleEntityRepository.save(oldExampleEntity);
    }
}
