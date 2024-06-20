package eksamen.atletik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "discipliner")
    @JsonBackReference
    private Set<DeltagerEntity> deltagerEntities = new HashSet<>();

    @OneToMany(mappedBy = "disciplin")
    @JsonBackReference
    private Set<ResultatEntity> resultater = new HashSet<>();

    public DisciplinEntity(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }
}
