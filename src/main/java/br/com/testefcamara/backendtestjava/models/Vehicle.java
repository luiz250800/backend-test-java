package br.com.testefcamara.backendtestjava.models;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe model de veículo.
 */
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime deleted_at;

    public Vehicle() {
    }

    /**
     * @param nmBrand
     * @param nmModel
     * @param nmColor
     * @param nrPlate
     * @param tpVehicle
     * @param company
     */
    public Vehicle(String nmBrand, String nmModel, String nmColor, String nrPlate, TypeVehicle tpVehicle, Company company) {
        this.nmBrand = nmBrand;
        this.nmModel = nmModel;
        this.nmColor = nmColor;
        this.nrPlate = nrPlate;
        this.tpVehicle = tpVehicle;
        this.company = company;
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

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}
