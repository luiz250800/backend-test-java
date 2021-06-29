package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Classe para forumulário de estabelecimento.
 */
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
    private int qtTotalVacanciesMotorcycle;
    @Min(1)
    private int qtTotalVacanciesCar;

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

    /**
     * Método para converter companyForm em company
     * @return
     */
    public Company converter() {
        return new Company(nmCompany, cdCnpj, nmAddress, nrPhone, qtTotalVacanciesMotorcycle, qtTotalVacanciesCar);
    }

    /**
     * Método para efetuar update em estabelecimento.
     * @param id
     * @param companyRepository
     * @return
     */
    public Company update(Long id, CompanyRepository companyRepository) {
        Company company = companyRepository.getById(id);

        if (this.qtTotalVacanciesMotorcycle - company.getQtVacanciesFilledMotorcycle() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível reduzir a este número de vagas para moto pois já estão ocupadas " + company.getQtVacanciesFilledMotorcycle() + " de " + company.getQtTotalVacanciesMotorcycle() + " vagas.");
        if (this.qtTotalVacanciesCar - company.getQtVacanciesFilledCar() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível reduzir a este número de vagas para carro pois já estão ocupadas " + company.getQtVacanciesFilledCar() + " de " + company.getQtTotalVacanciesCar() + " vagas.");

        company.setNmCompany(this.nmCompany);
        company.setCdCnpj(this.cdCnpj);
        company.setNmAddress(this.nmAddress);
        company.setNrPhone(this.nrPhone);
        company.setQtTotalVacanciesCar(this.qtTotalVacanciesCar);
        company.setQtTotalVacanciesMotorcycle(this.qtTotalVacanciesMotorcycle);

        return company;
    }
}
