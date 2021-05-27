package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Company;

public class CompanyForm {
    private String nmCompany;

    private String cdCnpj;

    private String nmAddress;

    private String nrPhone;

    private int qtVacanciesMotorcycle;

    private int qtVacanciesCar;

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

    public Company converter() {
        return new Company(nmCompany, cdCnpj, nmAddress, nrPhone, qtVacanciesMotorcycle, qtVacanciesCar);
    }
}