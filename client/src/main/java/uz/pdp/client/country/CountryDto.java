package uz.pdp.client.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private int id;
    private String name;
    private int continentId;
    private String continentName;
}
