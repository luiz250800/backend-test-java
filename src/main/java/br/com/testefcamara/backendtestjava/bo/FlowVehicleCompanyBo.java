package br.com.testefcamara.backendtestjava.bo;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;

/**
 * Classe BO para controle de fluxo de entrada e saida de veículos
 */
public class FlowVehicleCompanyBo {
    /**
     * Registra entrada de um veículo no estabelecimento, aumentando em 1 as vagas ocupadas.
     * @param companyRepository
     * @param id
     * @param typeVehicle
     * @return
     */
    public static Company registerEntranceVehicleCompany(CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);
        return typeVehicle.getInstance().reduce(company);
    }

    /**
     * Registra saída de um veículo no estabelecimento, diminuindo em 1 as vagas ocupadas.
     * @param companyRepository
     * @param id
     * @param typeVehicle
     * @return
     */
    public static Company registerOutputVehicleCompany(CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);
        return typeVehicle.getInstance().increments(company);
    }
}
