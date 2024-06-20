package eksamen.atletik.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ResultatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String disciplin;


 @ManyToOne
    @JoinColumn(name = "deltager_id")
    @JsonManagedReference
    private DeltagerEntity deltagerEntity;

    private String tid;
    private LocalDate dato;
    private Double distance;

 @ManyToOne
    @JoinColumn(name = "disciplin_id")
    private DisciplinEntity disciplinEntity;
}

