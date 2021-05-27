package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT a FROM Company a WHERE a.nmCompany LIKE %:nmCompany%")
    List<Company> findByNmCompany(String nmCompany);
}
