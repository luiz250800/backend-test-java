package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Classe para forumulário de alteração de veículo.
 */
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

    /**
     * Método para alteração de veículo.
     * @param id
     * @param vehicleRepository
     * @return
     */
    public Vehicle update(Long id, VehicleRepository vehicleRepository) {
        Vehicle vehicle = vehicleRepository.getById(id);

        vehicle.setNmBrand(this.nmBrand);
        vehicle.setNmModel(this.nmModel);
        vehicle.setNmColor(this.nmColor);
        vehicle.setNrPlate(this.nrPlate);

        return vehicle;
    }
}
