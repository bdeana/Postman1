package hr.java.web.helloworld.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private Long id;
    private String naziv;
    private Integer cijena;
    private String tip;
    private Integer sifra;
    private Integer kolicina;
}