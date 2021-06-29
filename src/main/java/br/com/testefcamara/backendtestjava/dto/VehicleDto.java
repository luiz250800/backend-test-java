package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

/**
 * Classe DTO para retorno de veículo.
 */
public class VehicleDto {
    private Long id;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrPlate;

    private TypeVehicle tpVehicle;

    private Company company;

    private LocalDateTime created_at;

    private LocalDateTime deleted_at;

    /**
     * @param vehicle
     */
    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.nmBrand = vehicle.getNmBrand();
        this.nmModel = vehicle.getNmModel();
        this.nmColor = vehicle.getNmColor();
        this.nrPlate = vehicle.getNrPlate();
        this.tpVehicle = vehicle.getTpVehicle();
        this.company = vehicle.getCompany();
        this.created_at = vehicle.getCreated_at();
        this.deleted_at = vehicle.getDeleted_at();
    }

    /**
     * Método para converter lista de veículo para lista de veículo DTO.
     * @param vehicle
     * @return
     */
    public static Page<VehicleDto> converter(Page<Vehicle> vehicle) {
        return vehicle.map(VehicleDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getNmBrand() {
        return nmBrand;
    }

    public String getNmModel() {
        return nmModel;
    }

    public String getNmColor() {
        return nmColor;
    }

    public String getNrPlate() {
        return nrPlate;
    }

    public TypeVehicle getTpVehicle() {
        return tpVehicle;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }
}
