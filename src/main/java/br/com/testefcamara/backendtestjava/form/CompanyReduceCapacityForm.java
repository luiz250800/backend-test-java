package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyReduceCapacityForm {
    public static Company registerCompanyVehicle (CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);

        if (TypeVehicle.CAR.equals(typeVehicle)){
            int qtVacanciesCar = company.getQtVacanciesCar();

            if(qtVacanciesCar > 0) {
                company.setQtVacanciesCar(qtVacanciesCar - 1);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro foram ocupadas!");
            }
        } else {
            int qtVacanciesMotorcycle = company.getQtVacanciesMotorcycle();

            if(qtVacanciesMotorcycle > 0) {
                company.setQtVacanciesMotorcycle(qtVacanciesMotorcycle - 1);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto foram ocupadas!");
            }
        }
        return company;
    }
}
