package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleDto {
    private Long id;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrBoard;

    private TypeVehicle tpVehicle;

    private Company company;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.nmBrand = vehicle.getNmBrand();
        this.nmModel = vehicle.getNmModel();
        this.nmColor = vehicle.getNmColor();
        this.nrBoard = vehicle.getNrBoard();
        this.tpVehicle = vehicle.getTpVehicle();
        this.company = company;
    }

    public static List<VehicleDto> converter(List<Vehicle> vehicle) {
        return vehicle.stream().map(VehicleDto::new).collect(Collectors.toList());
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

    public String getNrBoard() {
        return nrBoard;
    }

    public TypeVehicle getTpVehicle() {
        return tpVehicle;
    }

    public Company getCompany() {
        return company;
    }
}
