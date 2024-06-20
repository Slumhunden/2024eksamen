package eksamen.atletik.dto;

import eksamen.atletik.entity.DeltagerEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeltagerDto {
    private int id;
    private String navn;
    private String klub;
    private String gender;
    private int alder;
    private List<Integer> resultatIds;
    private List<Integer> disciplinIds;

    public DeltagerDto(DeltagerEntity deltagerEntity) {
        this.id = deltagerEntity.getId();
        this.navn = deltagerEntity.getNavn();
        this.klub = deltagerEntity.getKlub();
        this.gender = deltagerEntity.getGender();
        this.alder = deltagerEntity.getAlder();
    }
}
