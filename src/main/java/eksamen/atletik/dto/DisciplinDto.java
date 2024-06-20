package eksamen.atletik.dto;

import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.repository.DisciplinRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinDto {
    private int id;
    private String navn;
    private String resultatType;

    public DisciplinDto(DisciplinEntity disciplinEntity){
        this.id = disciplinEntity.getId();
        this.navn = disciplinEntity.getNavn();
        this.resultatType = disciplinEntity.getResultatType();
    }
}
