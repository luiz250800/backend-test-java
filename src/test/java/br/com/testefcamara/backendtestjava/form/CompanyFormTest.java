package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CompanyFormTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testaConverterRetornaCompany() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setNmCompany("Estabelecimento");
        companyForm.setCdCnpj("11.111.111/11111-11");
        companyForm.setNmAddress("Endereco");
        companyForm.setNrPhone("(11) 11111-1111");
        companyForm.setQtVacanciesCar(10);
        companyForm.setQtVacanciesMotorcycle(10);

        Company companyConverter = companyForm.converter();

        Company company = new Company("Estabelecimento", "11.111.111/11111-11", "Endereco", "(11) 11111-1111", 10, 10);

        Assertions.assertEquals(company.getNmCompany(), companyConverter.getNmCompany());
        Assertions.assertEquals(company.getCdCnpj(), companyConverter.getCdCnpj());
        Assertions.assertEquals(company.getNmAddress(), companyConverter.getNmAddress());
        Assertions.assertEquals(company.getNrPhone(), companyConverter.getNrPhone());
        Assertions.assertEquals(company.getQtVacanciesCar(), companyConverter.getQtVacanciesCar());
        Assertions.assertEquals(company.getQtVacanciesMotorcycle(), companyConverter.getQtVacanciesMotorcycle());
    }

    @Test
    public void testaUpdateRetornaCompany() {
        CompanyForm companyForm = new CompanyForm();

        companyForm.setNmCompany("Estabelecimento");
        companyForm.setCdCnpj("11.111.111/11111-11");
        companyForm.setNmAddress("Endereco");
        companyForm.setNrPhone("(11) 11111-1111");
        companyForm.setQtVacanciesCar(10);
        companyForm.setQtVacanciesMotorcycle(10);

        Company companyUpdate = companyForm.update(1L, companyRepository);

        Company company = new Company("Estabelecimento", "11.111.111/11111-11", "Endereco", "(11) 11111-1111", 10, 10);

        Assertions.assertEquals(1L, companyUpdate.getId());
        Assertions.assertEquals(company.getNmCompany(), companyUpdate.getNmCompany());
        Assertions.assertEquals(company.getCdCnpj(), companyUpdate.getCdCnpj());
        Assertions.assertEquals(company.getNmAddress(), companyUpdate.getNmAddress());
        Assertions.assertEquals(company.getNrPhone(), companyUpdate.getNrPhone());
        Assertions.assertEquals(company.getQtVacanciesCar(), companyUpdate.getQtVacanciesCar());
        Assertions.assertEquals(company.getQtVacanciesMotorcycle(), companyUpdate.getQtVacanciesMotorcycle());
    }
}
