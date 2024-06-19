package template.springbackendtemplate.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import template.springbackendtemplate.entity.ExampleEntity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExampleEntityDto {
    private int id;
    private String name;
    //Flere variabler kan indsættes her med private foran

    //Constructor tager en original entity og laver en dto ud af den
    public ExampleEntityDto(ExampleEntity exampleEntity) {
        this.id = exampleEntity.getId();
        this.name = exampleEntity.getName();
        //Flere variabler kan indsættes her med this.variabelnavn = exampleEntity.getVariabelnavn();
    }
}
