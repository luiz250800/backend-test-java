package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class FlowCompanyVehicleDto {
    private Long id;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrPlate;

    private TypeVehicle tpVehicle;

    private Company company;

    private LocalDateTime created_at;

    private LocalDateTime deleted_at;

    private long qtEntries;

    private long qtOutputs;

    public FlowCompanyVehicleDto(Vehicle vehicle, long qtEntries, long qtOutputs) {
        this.id = vehicle.getId();
        this.nmBrand = vehicle.getNmBrand();
        this.nmModel = vehicle.getNmModel();
        this.nmColor = vehicle.getNmColor();
        this.nrPlate = vehicle.getNrPlate();
        this.tpVehicle = vehicle.getTpVehicle();
        this.company = vehicle.getCompany();
        this.created_at = vehicle.getCreated_at();
        this.deleted_at = vehicle.getDeleted_at();
        this.qtEntries = qtEntries;
        this.qtOutputs = qtOutputs;
    }

    public static Page<FlowCompanyVehicleDto> converter(Page<Vehicle> vehicles) {
        long qtEntries = vehicles.stream().count();
        long qtOutputs = vehicles.stream().filter(vehicle -> vehicle.getDeleted_at() != null).count();
        return vehicles.map(vehicle -> new FlowCompanyVehicleDto(vehicle, qtEntries, qtOutputs));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmBrand() {
        return nmBrand;
    }

    public void setNmBrand(String nmBrand) {
        this.nmBrand = nmBrand;
    }

    public String getNmModel() {
        return nmModel;
    }

    public void setNmModel(String nmModel) {
        this.nmModel = nmModel;
    }

    public String getNmColor() {
        return nmColor;
    }

    public void setNmColor(String nmColor) {
        this.nmColor = nmColor;
    }

    public String getNrPlate() {
        return nrPlate;
    }

    public void setNrPlate(String nrPlate) {
        this.nrPlate = nrPlate;
    }

    public TypeVehicle getTpVehicle() {
        return tpVehicle;
    }

    public void setTpVehicle(TypeVehicle tpVehicle) {
        this.tpVehicle = tpVehicle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public long getQtEntries() {
        return qtEntries;
    }

    public void setQtEntries(long qtEntries) {
        this.qtEntries = qtEntries;
    }

    public long getQtOutputs() {
        return qtOutputs;
    }

    public void setQtOutputs(long qtOutputs) {
        this.qtOutputs = qtOutputs;
    }
}
