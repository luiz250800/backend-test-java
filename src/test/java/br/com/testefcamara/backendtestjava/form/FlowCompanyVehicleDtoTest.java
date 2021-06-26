package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.bo.FlowVehicleCompanyBo;
import br.com.testefcamara.backendtestjava.dto.FlowCompanyVehicleDto;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class FlowCompanyVehicleDtoTest {

    private Company company;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @BeforeEach
    @Transactional
    public void init() {
        Optional<Company> company = companyRepository.findById(1L);
        this.company = company.get();
        vehicleRepository.save(new Vehicle("Mercedes 1", "Esportivo 1", "preto 1", "hgb2004 1", TypeVehicle.CAR, this.company));

        Vehicle vehicle = new Vehicle("Mercedes 2", "Esportivo 2", "preto 2", "hgb2004 2", TypeVehicle.CAR, this.company);
        vehicle = vehicleRepository.save(vehicle);

        FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, vehicle.getCompany().getId(), vehicle.getTpVehicle());
        VehicleDeleteForm.deletedAt(vehicle.getId(), vehicleRepository);
    }

    @Test
    public void testaConstrutorDeObjetoFluxoDeVeiculoNoEstabelecimento() {
        List<Vehicle> vehicleList = vehicleRepository.findVehicleByCompanyAndDateInterval(this.company, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));

        FlowCompanyVehicleDto flowCompanyVehicleDto = new FlowCompanyVehicleDto(this.company, vehicleList);

        Assertions.assertEquals(2, flowCompanyVehicleDto.getQtEntries());
        Assertions.assertEquals(1, flowCompanyVehicleDto.getQtOutputs());
        Assertions.assertEquals(null, flowCompanyVehicleDto.getVehicles().get(0).getDeleted_at());
        Assertions.assertNotEquals(null, flowCompanyVehicleDto.getVehicles().get(1).getDeleted_at());
    }
}
