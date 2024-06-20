package eksamen.atletik.entity;

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
    private List<DeltagerEntity> deltagerEntities = new ArrayList<>();

    public void addDeltager(DeltagerEntity deltagerEntity) {
        deltagerEntities.add(deltagerEntity);
        deltagerEntity.getDiscipliner().add(this);
    }

    public DisciplinEntity(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }
}
