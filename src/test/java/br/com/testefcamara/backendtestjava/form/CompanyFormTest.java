package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@DataJpaTest
public class CompanyFormTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testaConverterRetornaCompanyCorretamente() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setNmCompany("Estabelecimento");
        companyForm.setCdCnpj("11.111.111/11111-11");
        companyForm.setNmAddress("Endereco");
        companyForm.setNrPhone("(11) 11111-1111");
        companyForm.setQtTotalVacanciesCar(10);
        companyForm.setQtTotalVacanciesMotorcycle(10);

        Company companyConverter = companyForm.converter();

        Company company = new Company("Estabelecimento", "11.111.111/11111-11", "Endereco", "(11) 11111-1111", 10, 10);

        Assertions.assertEquals(company.getNmCompany(), companyConverter.getNmCompany());
        Assertions.assertEquals(company.getCdCnpj(), companyConverter.getCdCnpj());
        Assertions.assertEquals(company.getNmAddress(), companyConverter.getNmAddress());
        Assertions.assertEquals(company.getNrPhone(), companyConverter.getNrPhone());
        Assertions.assertEquals(company.getQtTotalVacanciesCar(), companyConverter.getQtTotalVacanciesCar());
        Assertions.assertEquals(company.getQtTotalVacanciesCar(), companyConverter.getQtTotalVacanciesCar());
    }

    @Test
    public void testaUpdateRetornaCompanyCorretamente() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setNmCompany("Estabelecimento");
        companyForm.setCdCnpj("11.111.111/11111-11");
        companyForm.setNmAddress("Endereco");
        companyForm.setNrPhone("(11) 11111-1111");
        companyForm.setQtTotalVacanciesCar(12);
        companyForm.setQtTotalVacanciesMotorcycle(12);

        Company companyUpdate = companyForm.update(1L, companyRepository);

        Company company = new Company("Estabelecimento", "11.111.111/11111-11", "Endereco", "(11) 11111-1111", 12, 12);

        Assertions.assertEquals(1L, companyUpdate.getId());
        Assertions.assertEquals(company.getNmCompany(), companyUpdate.getNmCompany());
        Assertions.assertEquals(company.getCdCnpj(), companyUpdate.getCdCnpj());
        Assertions.assertEquals(company.getNmAddress(), companyUpdate.getNmAddress());
        Assertions.assertEquals(company.getNrPhone(), companyUpdate.getNrPhone());
        Assertions.assertEquals(company.getQtTotalVacanciesCar(), companyUpdate.getQtTotalVacanciesCar());
        Assertions.assertEquals(company.getQtTotalVacanciesCar(), companyUpdate.getQtTotalVacanciesCar());
    }

    @Test
    public void testaUpdateRetornaErroAoReduzirMuitoAQuantidadeTotalVagaMoto() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setQtTotalVacanciesMotorcycle(5);
        companyForm.setQtTotalVacanciesCar(12);

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> companyForm.update(1L, companyRepository));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Não é possível reduzir a este número de vagas para moto pois já estão ocupadas 8 de 10 vagas.\"", thrown.getMessage());
    }

    @Test
    public void testaUpdateRetornaErroAoReduzirMuitoAQuantidadeTotalVagaCarro() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setQtTotalVacanciesMotorcycle(12);
        companyForm.setQtTotalVacanciesCar(5);

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> companyForm.update(1L, companyRepository));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST + " \"Não é possível reduzir a este número de vagas para carro pois já estão ocupadas 8 de 10 vagas.\"", thrown.getMessage());
    }
}
