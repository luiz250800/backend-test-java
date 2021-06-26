package br.com.testefcamara.backendtestjava.bo;

import br.com.testefcamara.backendtestjava.enums.TypeVehicle;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;

public class FlowVehicleCompanyBo {
    public static Company registerEntranceVehicleCompany(CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);
        return typeVehicle.getInstance().reduce(company);
    }

    public static Company registerOutputVehicleCompany(CompanyRepository companyRepository, Long id, TypeVehicle typeVehicle) {
        Company company = companyRepository.getById(id);
        return typeVehicle.getInstance().increments(company);
    }
}
