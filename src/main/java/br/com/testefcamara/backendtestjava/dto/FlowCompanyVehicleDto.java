package br.com.testefcamara.backendtestjava.dto;

import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;

import java.util.List;

/**
 * Classe DTO para retorno de relatório de veículos no estabelecimento.
 */
public class FlowCompanyVehicleDto {

    private CompanyDto company;

    private List<VehicleFlowDto> vehicles;

    private long qtEntries;

    private long qtOutputs;

    /**
     * @param company
     * @param vehicles
     */
    public FlowCompanyVehicleDto(Company company, List<Vehicle> vehicles) {
        this.company = new CompanyDto(company);
        this.vehicles = VehicleFlowDto.converter(vehicles);
        this.qtEntries = vehicles.stream().count();
        this.qtOutputs = vehicles.stream().filter(vehicle -> vehicle.getDeleted_at() != null).count();
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public List<VehicleFlowDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleFlowDto> vehicles) {
        this.vehicles = vehicles;
    }

    public long getQtEntries() {
        return qtEntries;
    }

    public void setQtEntries(long qtEntries) {
        this.qtEntries = qtEntries;
    }

    public long getQtOutputs() {
        return qtOutputs;
    }

    public void setQtOutputs(long qtOutputs) {
        this.qtOutputs = qtOutputs;
    }
}
