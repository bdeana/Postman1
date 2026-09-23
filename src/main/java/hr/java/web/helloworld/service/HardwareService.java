package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Hardware;
import hr.java.web.helloworld.dto.HardwareDTO;


import java.util.List;
import java.util.Optional;


public interface HardwareService {

    List<HardwareDTO> getAllHardwares();

    List<HardwareDTO> getHardwaresBySifra(Integer sifra);

    Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id);

    boolean hardwareByIdExists(Integer id);

    /*boolean hardwareArticleById(Integer id);*/

    Integer saveNewHardware(HardwareDTO hardware);

    boolean deleteHardwareById(Integer id);
}
