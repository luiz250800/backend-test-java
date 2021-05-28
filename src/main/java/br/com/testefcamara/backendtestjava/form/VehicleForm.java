package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleForm {

    @NotNull @NotEmpty
    private String nmBrand;

    @NotNull @NotEmpty
    private String nmModel;

    @NotNull @NotEmpty
    private String nmColor;

    @NotNull @NotEmpty
    private String nrPlate;

    @NotNull @NotEmpty
    private TypeVehicle tpVehicle;

    @NotNull @NotEmpty
    private String nmCompany;

    public String getNmBrand() { return nmBrand; }

    public void setNmBrand(String nmBrand) { this.nmBrand = nmBrand; }

    public String getNmModel() { return nmModel; }

    public void setNmModel(String nmModel) { this.nmModel = nmModel; }

    public String getNmColor() { return nmColor; }

    public void setNmColor(String nmColor) { this.nmColor = nmColor; }

    public String getNrPlate() { return nrPlate; }

    public void setNrPlate(String nrPlate) { this.nrPlate = nrPlate; }

    public TypeVehicle getTpVehicle() { return tpVehicle; }

    public void setTpVehicle(TypeVehicle tpVehicle) { this.tpVehicle = tpVehicle; }

    public Vehicle converter(CompanyRepository companyRepository) {
        Company company = companyRepository.findByNmCompany(nmCompany);
        return new Vehicle(nmBrand, nmModel, nmColor, nrPlate, tpVehicle, company);
    }
}