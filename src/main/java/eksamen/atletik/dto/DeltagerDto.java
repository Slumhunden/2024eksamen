package eksamen.atletik.dto;

import eksamen.atletik.entity.DeltagerEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DeltagerDto {
    private int id;
    private String navn;
    private String klub;

    private String gender;
    private int alder;

    public DeltagerDto(DeltagerEntity deltagerEntity) {
        this.id = deltagerEntity.getId();
        this.navn = deltagerEntity.getNavn();
        this.klub = deltagerEntity.getKlub();
        this.gender = deltagerEntity.getGender();
        this.alder = deltagerEntity.getAlder();
    }
}
