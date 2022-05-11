package uz.pdp.country.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@Component
public class BeanService {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
