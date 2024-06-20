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
public class SpringBackendTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendTemplateApplication.class, args);
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

        };
    }
}
