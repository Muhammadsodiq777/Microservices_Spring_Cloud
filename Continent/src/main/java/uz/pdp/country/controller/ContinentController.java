package uz.pdp.country.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uz.pdp.country.DTO.ContinentDTO;
import uz.pdp.country.entity.ContinentEntity;
import uz.pdp.country.payload.ApiResponce;
import uz.pdp.country.service.ContinentService;

@RestController
@RequestMapping("/api/continent")
@RequiredArgsConstructor
public class ContinentController {

    private final ContinentService continentService;
    private final RestTemplate template;

    @GetMapping("/getAll")
    public HttpEntity<?> getAllContinents(){
        ApiResponce allContinents = continentService.getAllContinents();
        return ResponseEntity.status(allContinents.isSuccess()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(allContinents);
    }

    @GetMapping("/get/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        ApiResponce byId = continentService.getById(id);
        return ResponseEntity.status(byId.isSuccess()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(byId);
    }

    @PostMapping("/add")
    public HttpEntity<?> addContinent(@RequestBody ContinentEntity entity){
        ApiResponce apiResponce = continentService.addContinent(entity);
        return ResponseEntity.status(apiResponce.isSuccess()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @PostMapping("/edit/{id}")
    public HttpEntity<?> editById(@PathVariable Long id, @RequestBody ContinentEntity continent){
        ApiResponce apiResponce = continentService.editById(id, continent);
        return ResponseEntity.status(apiResponce.isSuccess()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        ApiResponce apiResponce = continentService.deleteById(id);
        return ResponseEntity.status(apiResponce.isSuccess()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponce);
    }

    @GetMapping("/with-countries/{id}")
    public HttpEntity<?> getContinentCountries(@PathVariable Long id){
        ContinentDTO continentCountries = continentService.getContinentCountries(id);
        return ResponseEntity.ok(continentCountries);
    }
}
