package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Article;
import hr.java.web.helloworld.domain.Hardware;
import hr.java.web.helloworld.dto.ArticleDTO;
import hr.java.web.helloworld.dto.HardwareDTO;
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
    public List<HardwareDTO> getAllHardwares() {
        return hardwareRepository.getAllHardwares()
                .stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwaresBySifra(Integer sifra) {
        return hardwareRepository.getHardwaresBySifra(sifra)
                .stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    /*
    @Override
    public List<Hardware> getAllHardwares() {
        return hardwareRepository.getAllHardwares();
    }

    @Override
    public List<Hardware> getHardwaresBySifra(Integer sifra) {
        return hardwareRepository.getHardwaresBySifra(sifra);
    }
*/
    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getNaziv(),
                hardware.getCijena(), hardware.getTip());
    }



}