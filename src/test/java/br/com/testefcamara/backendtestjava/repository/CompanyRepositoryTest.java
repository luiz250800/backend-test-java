package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testaFindAllNaoEstaVazio() {
        List<Company> company = companyRepository.findAll();
        Assertions.assertFalse(company.isEmpty());
    }

    @Test
    public void testaFindByIdNaoEstaVazioEBuscaEmpresaCorreta() {
        Optional<Company> company = companyRepository.findById(1L);
        Assertions.assertNotNull(company);
        Assertions.assertEquals("FCamara", company.get().getNmCompany());
    }
}
