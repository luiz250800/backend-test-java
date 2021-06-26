package br.com.testefcamara.backendtestjava.strategy;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MotorcycleStrategy implements VehicleStrategy {

    @Override
    public Company reduce(Company company) {
        if(company.calculateFreeVacanciesMotorcycle() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto foram ocupadas!");
        }
        return company.reduceVacanciesMotorcycle(1);
    }

    @Override
    public Company increments(Company company) {
        if(company.getQtVacanciesFilledMotorcycle() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto estão livres!");
        }
        return company.increaseVacanciesMotorcycle(1);
    }


}
