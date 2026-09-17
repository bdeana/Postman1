package hr.java.web.helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String naziv;
    private Integer cijena;
    private String tip;
}
