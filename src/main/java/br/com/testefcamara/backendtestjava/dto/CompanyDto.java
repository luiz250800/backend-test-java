package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.models.Company;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe DTO para retorno de estabelecimento.
 */
public class CompanyDto {
    private Long id;

    private String nmCompany;

    private String cdCnpj;

    private String nmAddress;

    private String nrPhone;

    private int qtTotalVacanciesMotorcycle;

    private int qtTotalVacanciesCar;

    private int qtVacanciesFilledMotorcycle;

    private int qtVacanciesFilledCar;

    /**
     * @param company
     */
    public CompanyDto(Company company) {
        this.id = company.getId();
        this.nmCompany = company.getNmCompany();
        this.cdCnpj = company.getCdCnpj();
        this.nmAddress = company.getNmAddress();
        this.nrPhone = company.getNrPhone();
        this.qtTotalVacanciesMotorcycle = company.getQtTotalVacanciesMotorcycle();
        this.qtTotalVacanciesCar = company.getQtTotalVacanciesCar();
        this.qtVacanciesFilledMotorcycle = company.getQtVacanciesFilledMotorcycle();
        this.qtVacanciesFilledCar = company.getQtVacanciesFilledCar();
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

    public int getQtTotalVacanciesMotorcycle() {
        return qtTotalVacanciesMotorcycle;
    }

    public int getQtTotalVacanciesCar() {
        return qtTotalVacanciesCar;
    }

    public int getQtVacanciesFilledMotorcycle() {
        return qtVacanciesFilledMotorcycle;
    }

    public int getQtVacanciesFilledCar() {
        return qtVacanciesFilledCar;
    }

    /**
     * Método para converter lista de estabelecimento para lista de estabelecimento DTO.
     * @param company
     * @return
     */
    public static List<CompanyDto> converter(List<Company> company) {
        return company.stream().map(CompanyDto::new).collect(Collectors.toList());
    }

}
