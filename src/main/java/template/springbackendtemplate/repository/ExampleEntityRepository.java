package template.springbackendtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import template.springbackendtemplate.entity.ExampleEntity;


//JpaRepository er en interface som giver os CRUD functionalitet
//Typen skal matche entity klassen og ID typen, det kan være String hvis det er den man bruger
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Integer>{

}
