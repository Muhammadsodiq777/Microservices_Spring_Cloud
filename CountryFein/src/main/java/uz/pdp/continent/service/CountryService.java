package uz.pdp.continent.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.continent.DTO.ContinentDTO;
import uz.pdp.continent.DTO.CountryDTO;
import uz.pdp.continent.entity.CountryEntity;
import uz.pdp.continent.payload.ApiResponce;
import uz.pdp.continent.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final RestTemplate template;

    public ApiResponce getAllContinents() {
        List<CountryEntity> all = countryRepository.findAll();
        return new ApiResponce("All continents", true, all);
    }

    public ApiResponce getById(Long id) {
        Optional<CountryEntity> all = countryRepository.findById(id);
        return new ApiResponce("Found", true, all);
    }

    public ApiResponce addCountry(CountryEntity entity) {
        CountryEntity save = countryRepository.save(entity);
        return new ApiResponce("Found", true, save);
    }


    public ApiResponce editById(Long id, CountryEntity continentEntity) {
        Optional<CountryEntity> byId = countryRepository.findById(id);

        CountryEntity continent = byId.get();

        continent.setName(continentEntity.getName());

        countryRepository.save(continent);
        return new ApiResponce("Done", true);
    }

    public ApiResponce deleteById(Long id) {
        countryRepository.deleteById(id);
        return new ApiResponce("Done", true);
    }

    public List<CountryEntity> getByContinentId(Long id) {
        List<CountryEntity> allByContinentId = countryRepository.findAllByContinentId(id);
        return allByContinentId;
    }


    public ApiResponce getWithContinentNames(Long id) {
        Optional<CountryEntity> byId = countryRepository.findById(id);
        ContinentDTO forObject = template.getForObject(
                "http://localhost:8081/api/continent/get/{{id}}",
                ContinentDTO.class,
                byId.get().getContinentId()
        );
        CountryDTO continentDTO
                = new CountryDTO(byId.get().getId(), byId.get().getName(), forObject.getName());
        return new ApiResponce("Done", true, continentDTO);
    }
}
