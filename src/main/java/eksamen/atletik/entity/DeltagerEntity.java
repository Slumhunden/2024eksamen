package eksamen.atletik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class DeltagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private String klub;
    private String gender;
    private int alder;

    @ManyToMany
    @JsonManagedReference
    private List<DisciplinEntity> discipliner = new ArrayList<>();

    @OneToMany(mappedBy = "deltagerEntity")
    @JsonBackReference
    private List<ResultatEntity> resultater = new ArrayList<>();

    public DeltagerEntity(String navn, String klub, String gender, int alder) {
        this.navn = navn;
        this.klub = klub;
        this.gender = gender;
        this.alder = alder;
    }
}
