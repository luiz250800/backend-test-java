package br.com.testefcamara.backendtestjava.strategy;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CarStrategy implements VehicleStrategy {

    @Override
    public Company reduce(Company company) {
        if (company.calculateFreeVacanciesCar() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro foram ocupadas!");
        }
        return company.reduceVacanciesCar(1);
    }

    @Override
    public Company increments(Company company) {
        if (company.getQtVacanciesFilledCar() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro estão livres!");
        }
        return company.increaseVacanciesCar(1);
    }
}
