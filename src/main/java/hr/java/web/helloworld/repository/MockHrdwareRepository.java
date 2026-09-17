package hr.java.web.helloworld.repository;

import hr.java.web.helloworld.domain.Hardware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MockHrdwareRepository implements HardwareRepository {
    private static List<Hardware> hardwareList;

    static {
        hardwareList = new ArrayList<>();

        Hardware firstHardware = new Hardware("H1", 100, "CPU", 1234, 10);
        Hardware secondHardware = new Hardware("H2", 200, "GPU", 1235, 20);
        Hardware thirdHardware = new Hardware("H3", 300, "MBO", 1235, 30);
        Hardware fourthHardware = new Hardware("H4", 400, "RAM", 1236, 40);

        hardwareList.add(firstHardware);
        hardwareList.add(secondHardware);
        hardwareList.add(thirdHardware);
        hardwareList.add(fourthHardware);
    }
    @Override
    public List<Hardware> getAllHardwares() {
        return hardwareList;
    }

    @Override
    public List<Hardware> getHardwaresBySifra(Integer sifra) {
        return hardwareList.stream()
                .filter(a -> a.getSifra().equals(sifra))
                .collect(Collectors.toList());
    }
}
