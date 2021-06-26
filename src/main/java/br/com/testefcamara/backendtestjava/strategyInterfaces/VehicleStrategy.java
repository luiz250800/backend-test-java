package br.com.testefcamara.backendtestjava.strategyInterfaces;

import br.com.testefcamara.backendtestjava.models.Company;

public interface VehicleStrategy {
    Company reduce(Company company);

    Company increments(Company company);
}
