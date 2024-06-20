package eksamen.atletik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private String resultatType;

    @ManyToMany
    @JoinTable(
            name = "deltager_disciplin",
            joinColumns = @JoinColumn(name = "disciplin_id"),
            inverseJoinColumns = @JoinColumn(name = "deltager_id")
    )
    private List<DeltagerEntity> deltagerEntities;

    public DisciplinEntity(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }
}
