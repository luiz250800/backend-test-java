package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.models.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyDto {
    private Long id;

    private String nmCompany;

    private String cdCnpj;

    private String nmAddress;

    private String nrPhone;

    private int qtVacanciesMotorcycle;

    private int qtVacanciesCar;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.nmCompany = company.getNmCompany();
        this.cdCnpj = company.getCdCnpj();
        this.nmAddress = company.getNmAddress();
        this.nrPhone = company.getNrPhone();
        this.qtVacanciesMotorcycle = company.getQtVacanciesMotorcycle();
        this.qtVacanciesCar = company.getQtVacanciesCar();
    }

    public static List<CompanyDto> converter(List<Company> company) {
        return company.stream().map(CompanyDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNmCompany() {
        return nmCompany;
    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public String getNmAddress() {
        return nmAddress;
    }

    public String getNrPhone() {
        return nrPhone;
    }

    public int getQtVacanciesMotorcycle() {
        return qtVacanciesMotorcycle;
    }

    public int getQtVacanciesCar() {
        return qtVacanciesCar;
    }
}
