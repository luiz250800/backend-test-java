package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.dto.VehicleFlowDto;
import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class VehicleFlowDtoTest {

    private Vehicle vehicle;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @BeforeEach
    @Transactional
    public void init() {
        Optional<Company> company = companyRepository.findById(1L);
        this.vehicle = new Vehicle("Mercedes 1", "Esportivo 1", "preto 1", "hgb2004 1", TypeVehicle.CAR, company.get());
        vehicleRepository.save(this.vehicle);
    }

    @Test
    public void testaConveterFluxoVeiculoDto () {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        List<VehicleFlowDto> vehicleFlowDto = VehicleFlowDto.converter(vehicles);

        Assertions.assertEquals(vehicles.get(0).getId(), vehicleFlowDto.get(0).getId());
        Assertions.assertEquals(vehicles.get(0).getNmBrand(), vehicleFlowDto.get(0).getNmBrand());
        Assertions.assertEquals(vehicles.get(0).getNmColor(), vehicleFlowDto.get(0).getNmColor());
        Assertions.assertEquals(vehicles.get(0).getNmModel(), vehicleFlowDto.get(0).getNmModel());
        Assertions.assertEquals(vehicles.get(0).getCreated_at(), vehicleFlowDto.get(0).getCreated_at());
        Assertions.assertEquals(vehicles.get(0).getDeleted_at(), vehicleFlowDto.get(0).getDeleted_at());
    }
}
