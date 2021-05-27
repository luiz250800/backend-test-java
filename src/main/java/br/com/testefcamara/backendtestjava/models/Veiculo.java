package br.com.testefcamara.backendtestjava.models;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;

public class Veiculo {

    private Long idVehicle;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrBoard;

    private TypeVehicle TpVehicle;

    private Company company;

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
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

    public String getNrBoard() {
        return nrBoard;
    }

    public void setNrBoard(String nrBoard) {
        this.nrBoard = nrBoard;
    }

    public TypeVehicle getTpVehicle() {
        return TpVehicle;
    }

    public void setTpVehicle(TypeVehicle tpVehicle) {
        TpVehicle = tpVehicle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
