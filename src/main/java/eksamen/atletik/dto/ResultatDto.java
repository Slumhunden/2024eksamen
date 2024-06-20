package eksamen.atletik.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultatDto {
    private String resultat;
    private String dato;
    private double score;
    private int deltagerId;
    private int disciplinId;



}

