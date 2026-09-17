package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Hardware;
import hr.java.web.helloworld.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HardwareServiceImpl implements HardwareService {
    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<Hardware> getAllHardwares() {
        return hardwareRepository.getAllHardwares();
    }

    @Override
    public List<Hardware> getHardwaresBySifra(Integer sifra) {
        return hardwareRepository.getHardwaresBySifra(sifra);
    }


}