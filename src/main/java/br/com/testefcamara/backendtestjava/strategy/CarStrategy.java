package br.com.testefcamara.backendtestjava.strategy;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe para strategy de carro.
 */
public class CarStrategy implements VehicleStrategy {

    /**
     * Método para validar e reduzir vagas de carro.
     * @param company
     * @return
     */
    @Override
    public Company reduce(Company company) {
        if (company.calculateFreeVacanciesCar() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro foram ocupadas!");
        }
        return company.reduceVacanciesCar(1);
    }

    /**
     * Método para validar e aumentar vagas de carro.
     * @param company
     * @return
     */
    @Override
    public Company increments(Company company) {
        if (company.getQtVacanciesFilledCar() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de carro estão livres!");
        }
        return company.increaseVacanciesCar(1);
    }
}
