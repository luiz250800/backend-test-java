package br.com.testefcamara.backendtestjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nmCompany;

    private String cdCnpj;

    private String nmAddress;

    private String nrPhone;

    private int qtVacanciesMotorcycle;

    private int qtVacanciesCar;

    public Company(Long id, String nmCompany, String cdCnpj, String nmAddress, String nrPhone, int qtVacanciesMotorcycle, int qtVacanciesCar) {
        this.id = id;
        this.nmCompany = nmCompany;
        this.cdCnpj = cdCnpj;
        this.nmAddress = nmAddress;
        this.nrPhone = nrPhone;
        this.qtVacanciesMotorcycle = qtVacanciesMotorcycle;
        this.qtVacanciesCar = qtVacanciesCar;
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

    public int getQtVacanciesMotorcycle() {
        return qtVacanciesMotorcycle;
    }

    public void setQtVacanciesMotorcycle(int qtVacanciesMotorcycle) {
        this.qtVacanciesMotorcycle = qtVacanciesMotorcycle;
    }

    public int getQtVacanciesCar() {
        return qtVacanciesCar;
    }

    public void setQtVacanciesCar(int qtVacanciesCar) {
        this.qtVacanciesCar = qtVacanciesCar;
    }
}
