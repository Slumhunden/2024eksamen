package eksamen.atletik.repository;

import eksamen.atletik.entity.DisciplinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinRepository extends JpaRepository<DisciplinEntity, Integer> {
}
