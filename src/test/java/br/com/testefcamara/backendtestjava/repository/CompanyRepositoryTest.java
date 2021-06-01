package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testaFindAllNaoDeveRetornarNullETemMaisDeUmRegistro() {
        List<Company> company = companyRepository.findAll();
        Assertions.assertNotNull(company);
    }

    @Test
    public void testaFindByIdNaoDeveRetornarNullENomeDeveSerIgualAStringNmCompany() {
        String nmCompany = "FCamara";
        Optional<Company> company = companyRepository.findById(1L);
        Assertions.assertNotNull(company);
        Assertions.assertEquals(nmCompany, company.get().getNmCompany());
    }

    @Test
    public void testaFindByIdDeveRetornarVazio() {
        Optional<Company> company = companyRepository.findById(0L);
        Assertions.assertEquals(Optional.empty(), company);
    }
}
