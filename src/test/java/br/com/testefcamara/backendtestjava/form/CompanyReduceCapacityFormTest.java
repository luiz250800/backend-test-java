package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CompanyReduceCapacityFormTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testaRegistroDeVeiculoNoEstabelecimento () {
        CompanyReduceCapacityForm.registerCompanyVehicle(companyRepository, 1L, TypeVehicle.CAR);
    }
}
