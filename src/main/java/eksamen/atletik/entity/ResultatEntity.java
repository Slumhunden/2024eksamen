package eksamen.atletik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ResultatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String resultat;
    private String dato;
    private double score;

    @ManyToOne
    @JoinColumn(name = "deltager_id")
    @JsonBackReference
    private DeltagerEntity deltager;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "disciplin_id")
    private DisciplinEntity disciplin;

    public ResultatEntity(String resultat, String dato, double score, DeltagerEntity deltager, DisciplinEntity disciplin) {
        this.resultat = resultat;
        this.dato = dato;
        this.score = score;
        this.deltager = deltager;
        this.disciplin = disciplin;
    }
}
