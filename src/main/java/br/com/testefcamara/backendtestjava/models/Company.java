package br.com.testefcamara.backendtestjava.models;

public class Company {

    private Long idCompany;

    private String nmCompany;

    private String cdCnpj;

    private String nmAddress;

    private String nrPhone;

    private int qtVacanciesMotorcycle;

    private int qtVacanciesCar;

    public Company(Long idCompany, String nmCompany, String cdCnpj, String nmAddress, String nrPhone, int qtVacanciesMotorcycle, int qtVacanciesCar) {
        this.idCompany = idCompany;
        this.nmCompany = nmCompany;
        this.cdCnpj = cdCnpj;
        this.nmAddress = nmAddress;
        this.nrPhone = nrPhone;
        this.qtVacanciesMotorcycle = qtVacanciesMotorcycle;
        this.qtVacanciesCar = qtVacanciesCar;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
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
