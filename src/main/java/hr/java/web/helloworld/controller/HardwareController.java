package hr.java.web.helloworld.controller;

import hr.java.web.helloworld.domain.Hardware;

import hr.java.web.helloworld.dto.ArticleDTO;
import hr.java.web.helloworld.dto.HardwareDTO;
import hr.java.web.helloworld.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {
    private HardwareService hardwareService;


    /*@GetMapping
    public List<HardwareDTO> getAllHardwares() {
        return hardwareService.getAllHardwares().stream().toList();
    }

    @GetMapping("/{sifra}")
    public List<HardwareDTO> filterHardwaressBySifra(@PathVariable Integer sifra) {
        return hardwareService.getHardwaresBySifra(sifra).stream().toList();
    }*/
    @GetMapping
    public List<Hardware> getAllHardwares() {
        return hardwareService.getAllHardwares().stream().toList();
    }

    @GetMapping("/{sifra}")
    public List<Hardware> filterHardwaresBySifra(@PathVariable Integer sifra) {
        return hardwareService.getHardwaresBySifra(sifra).stream().toList();
    }
}
