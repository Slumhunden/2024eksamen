package template.springbackendtemplate.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ManyToOneExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //Flere variabler kan indsættes her med private foran

    //Én ManyToOne relation skal have EN reference til det entity som den er forbundet til
    // der kan være MANGE af entities som referer til EN entity
    @ManyToOne
    @JoinColumn(name = "exampleEntity")
    @JsonBackReference
    private List<ManyToOneExampleEntity> manyToOneExampleEntities = new ArrayList<>();
}
