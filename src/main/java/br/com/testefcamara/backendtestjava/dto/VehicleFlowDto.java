package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Vehicle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe DTO para retorno de fluxo de veículo sem estabelecimento.
 */
public class VehicleFlowDto {

    private Long id;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrPlate;

    private TypeVehicle tpVehicle;

    private LocalDateTime created_at;

    private LocalDateTime deleted_at;

    /**
     * @param vehicle
     */
    public VehicleFlowDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.nmBrand = vehicle.getNmBrand();
        this.nmModel = vehicle.getNmModel();
        this.nmColor = vehicle.getNmColor();
        this.nrPlate = vehicle.getNrPlate();
        this.tpVehicle = vehicle.getTpVehicle();
        this.created_at = vehicle.getCreated_at();
        this.deleted_at = vehicle.getDeleted_at();
    }

    /**
     * Método para converter lista de veículo para fluxo veículos DTO sem estabelecimento.
     * @param vehicle
     * @return
     */
    public static List<VehicleFlowDto> converter(List<Vehicle> vehicle) {
        return vehicle.stream().map(VehicleFlowDto::new).collect(Collectors.toList());
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

}
