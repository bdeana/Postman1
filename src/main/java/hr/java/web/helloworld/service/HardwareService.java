package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Hardware;


import java.util.List;

public interface HardwareService {

    List<Hardware> getAllHardwares();

    List<Hardware> getHardwaresBySifra(Integer sifra);
}