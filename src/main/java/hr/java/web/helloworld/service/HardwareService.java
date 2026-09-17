package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Hardware;
import hr.java.web.helloworld.dto.HardwareDTO;


import java.util.List;

public interface HardwareService {

    /*List<Hardware> getAllHardwares();

    List<Hardware> getHardwaresBySifra(Integer sifra);*/
    List<HardwareDTO> getAllHardwares();

    List<HardwareDTO> getHardwaresBySifra(Integer sifra);
}