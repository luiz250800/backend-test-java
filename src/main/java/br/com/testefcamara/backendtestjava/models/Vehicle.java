package br.com.testefcamara.backendtestjava.models;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nmBrand;

    private String nmModel;

    private String nmColor;

    private String nrBoard;

    @Enumerated(EnumType.STRING)
    private TypeVehicle tpVehicle;

    @ManyToOne
    private Company company;

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

    public String getNrBoard() {
        return nrBoard;
    }

    public void setNrBoard(String nrBoard) {
        this.nrBoard = nrBoard;
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
}
