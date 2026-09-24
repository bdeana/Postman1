package hr.java.web.helloworld.service;

import hr.java.web.helloworld.domain.Hardware;
import hr.java.web.helloworld.dto.HardwareDTO;
import hr.java.web.helloworld.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(
                hardware.getNaziv(),
                hardware.getCijena(),
                hardware.getTip(),
                hardware.getSifra(),
                hardware.getKolicina()
        );
    }


    private Hardware convertHardwareDtoToHardware(HardwareDTO hardwareDTO) {
        return new Hardware(
                null,
                hardwareDTO.getNaziv(),
                hardwareDTO.getCijena(),
                hardwareDTO.getTip(),
                hardwareDTO.getSifra(),
                hardwareDTO.getKolicina()
        );
    }



    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id) {
        Optional<Hardware> updatedHardwareOptional =
                hardwareRepository.updateHardware(
                        convertHardwareDtoToHardware(hardwareDTO),
                        id
                );

        if (updatedHardwareOptional.isPresent()) {
            return Optional.of(
                    convertHardwareToHardwareDTO(updatedHardwareOptional.get())
            );
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {
        return hardwareRepository.hardwareByIdExists(id);
    }

    @Override
    public Integer saveNewHardware(HardwareDTO hardwareDTO) {
        return hardwareRepository.saveNewHardware(
                convertHardwareDtoToHardware(hardwareDTO)
        );
    }

    @Override
    public boolean deleteHardwareById(Integer id) {
        return hardwareRepository.deleteHardwareById(id);
    }
}
