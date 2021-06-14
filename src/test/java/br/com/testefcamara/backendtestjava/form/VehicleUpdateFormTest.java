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
public class VehicleUpdateFormTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CompanyRepository companyRepository;

    private Vehicle vehicleSave;

    @BeforeEach
    public void init() {
        Optional<Company> company = companyRepository.findById(1L);
        Vehicle vehicle = new Vehicle("Mercedes 2", "Esportivo 2", "preto 2", "hgb2004 2", TypeVehicle.CAR, company.get());
        this.vehicleSave = vehicleRepository.save(vehicle);
    }

    @Test
    public void testaUpdateRetornaVehicleCorretamente() {
        VehicleUpdateForm vehicleUpdateForm = new VehicleUpdateForm();

        vehicleUpdateForm.setNmBrand("Mercedes 2");
        vehicleUpdateForm.setNmModel("Esportivo 2");
        vehicleUpdateForm.setNmColor("preto 2");
        vehicleUpdateForm.setNrPlate("hgb2004 2");

        Vehicle vehicleUpdate = vehicleUpdateForm.update(1L, vehicleRepository);

        Assertions.assertEquals(this.vehicleSave.getNmBrand(), vehicleUpdate.getNmBrand());
        Assertions.assertEquals(this.vehicleSave.getNmModel(), vehicleUpdate.getNmModel());
        Assertions.assertEquals(this.vehicleSave.getNmColor(), vehicleUpdate.getNmColor());
        Assertions.assertEquals(this.vehicleSave.getNrPlate(), vehicleUpdate.getNrPlate());
        Assertions.assertEquals(this.vehicleSave.getTpVehicle(), vehicleUpdate.getTpVehicle());
    }
}
