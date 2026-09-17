package hr.java.web.helloworld.repository;

import hr.java.web.helloworld.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardwares();

    List<Hardware> getHardwaresBySifra(Integer sifra);
}
