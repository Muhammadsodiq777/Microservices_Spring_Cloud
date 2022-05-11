package uz.pdp.continent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.continent.entity.CountryEntity;
import uz.pdp.continent.payload.ApiResponce;
import uz.pdp.continent.service.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/getAll")
    public HttpEntity<?> getAllContinents() {
        ApiResponce allContinents = countryService.getAllContinents();
        return ResponseEntity.status(allContinents.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(allContinents);
    }

    @GetMapping("/getBy/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        ApiResponce byId = countryService.getById(id);
        return ResponseEntity.status(byId.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(byId);
    }


    @PostMapping("/add")
    public HttpEntity<?> addContinent(@RequestBody CountryEntity entity) {
        ApiResponce apiResponce = countryService.addCountry(entity);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @PostMapping("/edit/{id}")
    public HttpEntity<?> editById(@PathVariable Long id, @RequestBody CountryEntity country) {
        ApiResponce apiResponce = countryService.editById(id, country);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteById(@PathVariable Long id) {
        ApiResponce apiResponce = countryService.deleteById(id);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @GetMapping("/get/{continentId}")
    public List<CountryEntity> getByContinentId(@PathVariable Long continentId) {
        return countryService.getByContinentId(continentId);
    }

    @GetMapping("/with-continentnames/{id}")
    public HttpEntity<?> getWithContinentNames(@PathVariable Long id) {
        ApiResponce withContinentNames = countryService.getWithContinentNames(id);
        return ResponseEntity.status(withContinentNames.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(withContinentNames);

    }
}
