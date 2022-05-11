package uz.pdp.country.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.client.country.CountryDto;
import uz.pdp.client.country.CountryInterface;
import uz.pdp.country.DTO.ContinentDTO;
import uz.pdp.country.DTO.CountryDTO;
import uz.pdp.country.entity.ContinentEntity;
import uz.pdp.country.payload.ApiResponce;
import uz.pdp.country.repository.ContinentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContinentService {
    private final ContinentRepository continentRepository;
    private final RestTemplate template;
    private final CountryInterface countryInterface;


    public ApiResponce getAllContinents() {
//        List<ContinentEntity> all = continentRepository.findAll();
        CountryDto allCountry = countryInterface.getAllCountry();
        return new ApiResponce("All continents", true, allCountry);
    }

    public ApiResponce getById(Long id) {
        Optional<ContinentEntity> all = continentRepository.findById(id);
        return new ApiResponce("Found", true, all);
    }

    public ApiResponce addContinent(ContinentEntity continent) {
        ContinentEntity save = continentRepository.save(continent);
        return new ApiResponce("Done", true, save);
    }


    public ApiResponce editById(Long id, ContinentEntity continentEntity) {
        Optional<ContinentEntity> byId = continentRepository.findById(id);

        ContinentEntity continent = byId.get();

        continent.setName(continentEntity.getName());

        continentRepository.save(continent);
        return new ApiResponce("Done", true);
    }

    public ApiResponce deleteById(Long id) {
        continentRepository.deleteById(id);
        return new ApiResponce("Done", true);
    }

    public ContinentDTO getContinentCountries(Long id) {
        Optional<ContinentEntity> byId = continentRepository.findById(id);
//        List<CountryDTO> countryDTOList = template.getForObject(
//                "http://localhost:8080/api/country/get/{continentId}",
//                List.class,
//                byId.get().getId()
//        );

        CountryDto allCountry = countryInterface.getAllCountry();

        return new ContinentDTO(byId.get().getId(), byId.get().getName(), (List<CountryDTO>) allCountry);
    }
}
