package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Company;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CompanyForm {
    @NotNull @NotEmpty
    private String nmCompany;
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$")
    private String cdCnpj;
    @NotNull @NotEmpty
    private String nmAddress;
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}")
    private String nrPhone;
    @Min(1)
    private int qtVacanciesMotorcycle;
    @Min(1)
    private int qtVacanciesCar;

    public String getNmCompany() { return nmCompany; }

    public void setNmCompany(String nmCompany) { this.nmCompany = nmCompany; }

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

    public void setQtVacanciesMotorcycle(int qtVacanciesMotorcycle) { this.qtVacanciesMotorcycle = qtVacanciesMotorcycle; }

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
