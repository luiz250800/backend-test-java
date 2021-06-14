package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT a FROM Vehicle a WHERE a.company=:company AND a.created_at BETWEEN :dhStart and :dhEnd")
    List<Vehicle> findVehicleByCompanyAndDateInterval(Company company, LocalDateTime dhStart, LocalDateTime dhEnd);
}
