package eksamen.atletik;

import eksamen.atletik.entity.DeltagerEntity;
import eksamen.atletik.entity.DisciplinEntity;
import eksamen.atletik.entity.ResultatEntity;
import eksamen.atletik.repository.DeltagerRepository;
import eksamen.atletik.repository.DisciplinRepository;
import eksamen.atletik.repository.ResultatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner importData(DisciplinRepository disciplinRepository, DeltagerRepository deltagerRepository, ResultatRepository resultatRepository){
        return args -> {
            // Importer data her
            List<DisciplinEntity> discipliner = new ArrayList<>();
            discipliner.add(new DisciplinEntity("100 meter","tid"));
            discipliner.add(new DisciplinEntity("Længdespring","distance"));
            discipliner.add(new DisciplinEntity("Højdespring","distance"));
            discipliner.add(new DisciplinEntity("Kuglestød","distance"));
            discipliner.add(new DisciplinEntity("200 meter","tid"));
            disciplinRepository.saveAll(discipliner);

            List<DeltagerEntity> deltagere = new ArrayList<>();
            deltagere.add(new DeltagerEntity("Anders And","Andeby Atletik", "M", 25));
            deltagere.add(new DeltagerEntity("Bent Bentsen","Bent Atletik", "M", 30));
            deltagere.add(new DeltagerEntity("Carina Carlsen","Carlsberg Atletik", "K", 35));
            deltagere.add(new DeltagerEntity("Springer Sørensen","Andeby Atletik", "M", 25));
            deltagerRepository.saveAll(deltagere);

            List<ResultatEntity> resultater = new ArrayList<>();
            resultater.add(new ResultatEntity("10.5", "2021-06-01", 10.5, deltagere.get(0), discipliner.get(0)));
            resultater.add(new ResultatEntity("10.6", "2021-06-01", 10.6, deltagere.get(1), discipliner.get(0)));
            resultater.add(new ResultatEntity("10.7", "2021-06-01", 10.7, deltagere.get(2), discipliner.get(0)));
            resultater.add(new ResultatEntity("10.8", "2021-06-01", 10.8, deltagere.get(3), discipliner.get(0)));
            resultater.add(new ResultatEntity("10.9", "2021-06-01", 10.9, deltagere.get(0), discipliner.get(0)));
            resultater.add(new ResultatEntity("11.0", "2021-06-01", 11.0, deltagere.get(1), discipliner.get(0)));
            resultatRepository.saveAll(resultater);
        };
    }
}
