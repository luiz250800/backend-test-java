package br.com.testefcamara.backendtestjava.strategyInterfaces;

import br.com.testefcamara.backendtestjava.models.Company;

/**
 * Interface de strategy para controle de vagas de veículo.
 */
public interface VehicleStrategy {
    /**
     * Método de interface para reduzir vagas.
     * @param company
     * @return
     */
    Company reduce(Company company);

    /**
     * Método de interface para aumentar vagas.
     * @param company
     * @return
     */
    Company increments(Company company);
}
