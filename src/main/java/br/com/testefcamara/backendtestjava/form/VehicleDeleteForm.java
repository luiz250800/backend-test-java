package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;

import java.time.LocalDateTime;

public class VehicleDeleteForm {
    public static Vehicle deletedAt(Long id, VehicleRepository vehicleRepository) {
        Vehicle vehicle = vehicleRepository.getById(id);

        vehicle.setDeleted_at(LocalDateTime.now());

        return vehicle;
    }
}
