package hr.java.web.helloworld.controller;

import hr.java.web.helloworld.domain.Hardware;

import hr.java.web.helloworld.dto.ArticleDTO;
import hr.java.web.helloworld.dto.HardwareDTO;
import hr.java.web.helloworld.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {
    private HardwareService hardwareService;


    @GetMapping
    public List<HardwareDTO> getAllHardwares() {
        return hardwareService.getAllHardwares().stream().toList();
    }

    @GetMapping("/{sifra}")
    public List<HardwareDTO> filterHardwaressBySifra(@PathVariable Integer sifra) {
        return hardwareService.getHardwaresBySifra(sifra).stream().toList();
    }
    /*

    @GetMapping
    public List<Hardware> getAllHardwares() {
        return hardwareService.getAllHardwares().stream().toList();
    }

    @GetMapping("/{sifra}")
    public List<Hardware> filterHardwaresBySifra(@PathVariable Integer sifra) {
        return hardwareService.getHardwaresBySifra(sifra).stream().toList();
    }*/


    @PostMapping("/new")
    public ResponseEntity<Void> saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        hardwareService.saveNewHardware(hardwareDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/hardware/{hardwareId}")
    public ResponseEntity<HardwareDTO> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hardwareDTO, hardwareId);
            return ResponseEntity.ok(hardwareDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/hardware/{hardwareId}")
    public ResponseEntity<?> deleteHardware(@PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            boolean result = hardwareService.deleteHardwareById(hardwareId);
            if(result) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
