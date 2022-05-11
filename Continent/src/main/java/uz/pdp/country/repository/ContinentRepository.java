package uz.pdp.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.country.entity.ContinentEntity;

public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {
}
