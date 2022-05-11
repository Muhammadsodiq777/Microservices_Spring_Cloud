package uz.pdp.country.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiResponce {

    private String message;
    private boolean success;
    private Object object;

    public ApiResponce(String done, boolean b) {
    }
}
