package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
