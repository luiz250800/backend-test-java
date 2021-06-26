package br.com.testefcamara.backendtestjava.models;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nmCompany;

    @Column(nullable = false, unique = true)
    private String cdCnpj;

    @Column(nullable = false)
    private String nmAddress;

    @Column(nullable = false)
    private String nrPhone;

    @Column(nullable = false)
    private int qtTotalVacanciesMotorcycle;

    @Column(nullable = false)
    private int qtTotalVacanciesCar;

    @Column(nullable = false)
    private int qtVacanciesFilledMotorcycle = 0;

    @Column(nullable = false)
    private int qtVacanciesFilledCar = 0;

    public Company (){

    }

    public Company(String nmCompany, String cdCnpj, String nmAddress, String nrPhone, int qtTotalVacanciesMotorcycle, int qtTotalVacanciesCar) {
        this.nmCompany = nmCompany;
        this.cdCnpj = cdCnpj;
        this.nmAddress = nmAddress;
        this.nrPhone = nrPhone;
        this.qtTotalVacanciesMotorcycle = qtTotalVacanciesMotorcycle;
        this.qtTotalVacanciesCar = qtTotalVacanciesCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmCompany() {
        return nmCompany;
    }

    public void setNmCompany(String nmCompany) {
        this.nmCompany = nmCompany;
    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public void setCdCnpj(String cdCnpj) {
        this.cdCnpj = cdCnpj;
    }

    public String getNmAddress() {
        return nmAddress;
    }

    public void setNmAddress(String nmAddress) {
        this.nmAddress = nmAddress;
    }

    public String getNrPhone() {
        return nrPhone;
    }

    public void setNrPhone(String nrPhone) {
        this.nrPhone = nrPhone;
    }

    public int getQtTotalVacanciesMotorcycle() {
        return qtTotalVacanciesMotorcycle;
    }

    public void setQtTotalVacanciesMotorcycle(int qtTotalVacanciesMotorcycle) {
        this.qtTotalVacanciesMotorcycle = qtTotalVacanciesMotorcycle;
    }

    public int getQtTotalVacanciesCar() {
        return qtTotalVacanciesCar;
    }

    public void setQtTotalVacanciesCar(int qtTotalVacanciesCar) {
        this.qtTotalVacanciesCar = qtTotalVacanciesCar;
    }

    public int getQtVacanciesFilledMotorcycle() {
        return qtVacanciesFilledMotorcycle;
    }

    public void setQtVacanciesFilledMotorcycle(int qtVacanciesMotorcycle) {
        this.qtVacanciesFilledMotorcycle = qtVacanciesMotorcycle;
    }

    public int getQtVacanciesFilledCar() {
        return qtVacanciesFilledCar;
    }

    public void setQtVacanciesFilledCar(int qtVacanciesCar) {
        this.qtVacanciesFilledCar = qtVacanciesCar;
    }

    public Company increaseVacanciesCar(int qtVacanciesIncrease) {
        this.qtVacanciesFilledCar = this.qtVacanciesFilledCar - qtVacanciesIncrease;
        return this;
    }

    public Company increaseVacanciesMotorcycle(int qtVacanciesIncrease) {
        this.qtVacanciesFilledMotorcycle = this.qtVacanciesFilledMotorcycle - qtVacanciesIncrease;
        return this;
    }

    public Company reduceVacanciesCar(int qtVacanciesReduce) {
        this.qtVacanciesFilledCar = this.qtVacanciesFilledCar + qtVacanciesReduce;
        return this;
    }

    public Company reduceVacanciesMotorcycle(int qtVacanciesReduce) {
        this.qtVacanciesFilledMotorcycle = this.qtVacanciesFilledMotorcycle + qtVacanciesReduce;
        return this;
    }

    public int calculateFreeVacanciesCar() {
        return this.qtTotalVacanciesCar - this.qtVacanciesFilledCar;
    }

    public int calculateFreeVacanciesMotorcycle() {
        return this.qtTotalVacanciesMotorcycle - this.qtVacanciesFilledMotorcycle;
    }
}
