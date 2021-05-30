package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleUpdateForm {
    @NotNull
    @NotEmpty
    private String nmBrand;

    @NotNull @NotEmpty
    private String nmModel;

    @NotNull @NotEmpty
    private String nmColor;

    @NotNull @NotEmpty
    private String nrPlate;

    @NotNull
    private TypeVehicle tpVehicle;

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

    public Vehicle update(Long id, VehicleRepository vehicleRepository) {
        Vehicle vehicle = vehicleRepository.getById(id);

        vehicle.setNmBrand(this.nmBrand);
        vehicle.setNmModel(this.nmModel);
        vehicle.setNmColor(this.nmColor);
        vehicle.setNrPlate(this.nrPlate);
        vehicle.setTpVehicle(this.tpVehicle);

        return vehicle;
    }
}
