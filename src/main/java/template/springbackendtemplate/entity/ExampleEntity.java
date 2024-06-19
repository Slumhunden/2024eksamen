package template.springbackendtemplate.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //Flere variabler kan indsættes her med private foran

    /*
    Bidirectional OneToMany/ManyToOne relation
    OneToMany relation skal have en liste af ManyToOne entities
    mappedBy skal være navnet på variablen i ManyToOne entityen, som refererer til denne klasse
    i dette tilfælde er det "exampleEntity" i ManyToOneExampleEntity

    JsonManagedReference bruges til at undgå uendelige loops i JSON output
    JsonBackReference sksal være på ManyToOne klassen
     */

    @OneToMany(mappedBy = "exampleEntity")
    @JsonManagedReference
    private List<ManyToOneExampleEntity> manyToOneExampleEntities = new ArrayList<>();
}
