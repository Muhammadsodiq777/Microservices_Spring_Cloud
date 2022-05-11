package uz.pdp.continent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.continent.entity.CountryEntity;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    List<CountryEntity> findAllByContinentId (Long id);

}
