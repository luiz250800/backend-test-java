package br.com.testefcamara.backendtestjava.strategy;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe para strategy de moto.
 */
public class MotorcycleStrategy implements VehicleStrategy {

    /**
     * Método para validar e reduzir vagas de moto.
     * @param company
     * @return
     */
    @Override
    public Company reduce(Company company) {
        if(company.calculateFreeVacanciesMotorcycle() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto foram ocupadas!");
        }
        return company.reduceVacanciesMotorcycle(1);
    }

    /**
     * Método para validar e aumentar vagas de moto.
     * @param company
     * @return
     */
    @Override
    public Company increments(Company company) {
        if(company.getQtVacanciesFilledMotorcycle() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todas as vagas de moto estão livres!");
        }
        return company.increaseVacanciesMotorcycle(1);
    }


}
