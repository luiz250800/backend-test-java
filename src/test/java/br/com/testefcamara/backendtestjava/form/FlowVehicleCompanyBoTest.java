package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.bo.FlowVehicleCompanyBo;
import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@DataJpaTest
public class FlowVehicleCompanyBoTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testaRegistroDeVeiculoMotoNoEstabelecimentoCorretamente () {
        Company companyVehicleMotocycle = FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE);

        Assertions.assertEquals(9, companyVehicleMotocycle.getQtVacanciesFilledMotorcycle());
        Assertions.assertEquals(8, companyVehicleMotocycle.getQtVacanciesFilledCar());
    }

    @Test
    public void testaRegistroDeVeiculoCarroNoEstabelecimentoCorretamente () {
        Company companyVehicleCar = FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.CAR);

        Assertions.assertEquals(9, companyVehicleCar.getQtVacanciesFilledCar());
        Assertions.assertEquals(8, companyVehicleCar.getQtVacanciesFilledMotorcycle());
    }

    @Test
    public void testaRegistroDeVeiculoMotoNoEstabelecimentoAlemDoLimite () {
        FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE);
        FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE);

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Todas as vagas de moto foram ocupadas!\"", thrown.getMessage());
    }

    @Test
    public void testaRegistroDeVeiculoCarroNoEstabelecimentoAlemDoLimite () {
        FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.CAR);
        FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.CAR);

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, 1L, TypeVehicle.CAR));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Todas as vagas de carro foram ocupadas!\"", thrown.getMessage());
    }

    @Test
    public void testaExclusaoDeVeiculoMotoNoEstabelecimentoCorretamente () {
        Company companyVehicleCar = FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE);

        Assertions.assertEquals(7, companyVehicleCar.getQtVacanciesFilledMotorcycle());
        Assertions.assertEquals(8, companyVehicleCar.getQtVacanciesFilledCar());
    }

    @Test
    public void testaExclusaoDeVeiculoCarroNoEstabelecimentoCorretamente () {
        Company companyVehicleCar = FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.CAR);

        Assertions.assertEquals(7, companyVehicleCar.getQtVacanciesFilledCar());
        Assertions.assertEquals(8, companyVehicleCar.getQtVacanciesFilledMotorcycle());
    }

    @Test
    public void testaExclusaoDeVeiculoMotoNoEstabelecimentoAlemDoLimite () {
        int i = 0;
        while (i <= 7) {
            FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE);
            i++;
        }

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.MOTORCYCLE));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Todas as vagas de moto estão livres!\"", thrown.getMessage());
    }

    @Test
    public void testaExclusaoDeVeiculoCarroNoEstabelecimentoAlemDoLimite () {
        int i = 0;
        while (i <= 7) {
            FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.CAR);
            i++;
        }

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, 1L, TypeVehicle.CAR));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Todas as vagas de carro estão livres!\"", thrown.getMessage());
    }
}
