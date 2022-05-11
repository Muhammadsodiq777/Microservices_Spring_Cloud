package uz.pdp.client.country;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "country", path = "/api/country")
public interface CountryInterface {
    @GetMapping("/getAll")
     CountryDto getAllCountry();
}
