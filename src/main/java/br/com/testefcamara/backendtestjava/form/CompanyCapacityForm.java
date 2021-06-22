package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyCapacityForm {
    public static Company registerCompanyVehicle (CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);

        if (TypeVehicle.CAR.equals(typeVehicle)){
            int qtFreeVacanciesCar = company.getQtTotalVacanciesCar() - company.getQtVacanciesFilledCar();
            if (qtFreeVacanciesCar <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro foram ocupadas!");
            }
            return company.reduceVacanciesCar(1);
        }

        int qtFreeVacanciesMotorcycle = company.getQtTotalVacanciesMotorcycle() - company.getQtVacanciesFilledMotorcycle();
        if(qtFreeVacanciesMotorcycle <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto foram ocupadas!");
        }
        return company.reduceVacanciesMotorcycle(1);
    }

    public static Company deleteCompanyVehicle (CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);

        if (TypeVehicle.CAR.equals(typeVehicle)){
            if (company.getQtVacanciesFilledCar() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro estão livres!");
            }
            return company.increaseVacanciesCar(1);
        }

        if(company.getQtVacanciesFilledMotorcycle() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto estão livres!");
        }
        return company.increaseVacanciesMotorcycle(1);
    }
}
