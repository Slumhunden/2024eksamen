package eksamen.atletik.repository;


import eksamen.atletik.entity.ResultatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<ResultatEntity, Integer> {
    List<ResultatEntity> findByDeltagerEntity_Id(int deltagerId);
}
