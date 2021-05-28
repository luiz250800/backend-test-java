package br.com.testefcamara.backendtestjava.models;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nmBrand;

    @Column(nullable = false)
    private String nmModel;

    @Column(nullable = false)
    private String nmColor;

    @Column(nullable = false)
    private String nrPlate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeVehicle tpVehicle;

    @ManyToOne(optional = false)
    private Company company;

    public Vehicle() {
    }

    public Vehicle( String nmBrand, String nmModel, String nmColor, String nrPlate, TypeVehicle tpVehicle, Company company) {
        this.nmBrand = nmBrand;
        this.nmModel = nmModel;
        this.nmColor = nmColor;
        this.nrPlate = nrPlate;
        this.tpVehicle = tpVehicle;
        this.company = company;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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
}
