package eksamen.atletik.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class DeltagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private String klub;
    private String køn;
    private int alder;

    @ManyToMany
    @JoinTable(
            name = "deltager_disciplin",
            joinColumns = @JoinColumn(name = "deltager_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplin_id")
    )
    @JsonManagedReference
    private Set<DisciplinEntity> discipliner = new HashSet<>();

    @OneToMany(mappedBy = "deltager")
    @JsonManagedReference
    private Set<ResultatEntity> resultater = new HashSet<>();

    public DeltagerEntity(String navn, String klub, String køn, int alder) {
        this.navn = navn;
        this.klub = klub;
        this.køn = køn;
        this.alder = alder;
    }

    public void addDisciplin(DisciplinEntity disciplinEntity) {
        this.discipliner.add(disciplinEntity);
        disciplinEntity.getDeltagerEntities().add(this);
    }

    public void removeDisciplin(DisciplinEntity disciplinEntity) {
        this.discipliner.remove(disciplinEntity);
        disciplinEntity.getDeltagerEntities().remove(this);
    }

    public void addResultat(ResultatEntity resultatEntity) {
        this.resultater.add(resultatEntity);
    }
}
