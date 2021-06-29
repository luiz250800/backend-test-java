package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;

import java.time.LocalDateTime;

/**
 * Classe para formulário de exclusão de veículo.
 */
public class VehicleDeleteForm {

    /**
     * Método de esclusão de veículo.
     * @param id
     * @param vehicleRepository
     * @return
     */
    public static Vehicle deletedAt(Long id, VehicleRepository vehicleRepository) {
        Vehicle vehicle = vehicleRepository.getById(id);

        vehicle.setDeleted_at(LocalDateTime.now());

        return vehicle;
    }
}
