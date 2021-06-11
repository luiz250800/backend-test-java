package br.com.testefcamara.backendtestjava.form;

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

import java.util.Optional;

@DataJpaTest
public class VehicleFormTest {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CompanyRepository companyRepository;

    private Vehicle vehicle;

    @BeforeEach
    public void init() {
        Optional<Company> company = companyRepository.findById(1L);
        this.vehicle = new Vehicle("Mercedes 1", "Esportivo 1", "preto 1", "hgb2004 1", TypeVehicle.CAR, company.get());
    }

    @Test
    public void testaConveterRetornaVehicleCorretamente() {
        VehicleForm vehicleForm = new VehicleForm();

        vehicleForm.setNmBrand("Mercedes 1");
        vehicleForm.setNmModel("Esportivo 1");
        vehicleForm.setNmColor("preto 1");
        vehicleForm.setNrPlate("hgb2004 1");
        vehicleForm.setTpVehicle(TypeVehicle.CAR);
        vehicleForm.setIdCompany(1L);

        Vehicle vehicleConveter = vehicleForm.converter(companyRepository);

        Assertions.assertEquals(this.vehicle.getNmBrand(), vehicleConveter.getNmBrand());
        Assertions.assertEquals(this.vehicle.getNmModel(), vehicleConveter.getNmModel());
        Assertions.assertEquals(this.vehicle.getNmColor(), vehicleConveter.getNmColor());
        Assertions.assertEquals(this.vehicle.getNrPlate(), vehicleConveter.getNrPlate());
        Assertions.assertEquals(this.vehicle.getTpVehicle(), vehicleConveter.getTpVehicle());
    }
}
