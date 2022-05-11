package uz.pdp.continent.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponce {
    private String message;
    private boolean success;
    private Object object;

    public ApiResponce(String done, boolean b) {

    }
}
