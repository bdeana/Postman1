package hr.java.web.helloworld.repository;

import hr.java.web.helloworld.domain.Hardware;

import java.util.List;
import java.util.Optional;


public interface HardwareRepository {
    List<Hardware> getAllHardwares();

    List<Hardware> getHardwaresBySifra(Integer sifra);
    Optional<Hardware> updateHardware(Hardware hardware, Integer id);

    boolean hardwareByIdExists(Integer id);

    Integer saveNewHardware(Hardware hardware);

    boolean deleteHardwareById(Integer id);
}
