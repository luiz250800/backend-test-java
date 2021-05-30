package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
