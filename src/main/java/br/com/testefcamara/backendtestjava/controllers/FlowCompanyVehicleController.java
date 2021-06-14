package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.FlowCompanyVehicleDto;
import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.form.FlowCompanyVehicleForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/flowCampanyVehicle", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class FlowCompanyVehicleController {

    private final CompanyRepository companyRepository;

    private final VehicleRepository vehicleRepository;

    public FlowCompanyVehicleController(CompanyRepository companyRepository, VehicleRepository vehicleRepository) {
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping(value = "/{idCompany}")
    public FlowCompanyVehicleDto flowCampanyVehicle(@PathVariable Long idCompany, @RequestBody FlowCompanyVehicleForm flowCompanyVehicleForm) {
        Optional<Company> optionalCompany = companyRepository.findById(idCompany);
        if(optionalCompany.isPresent()){
            List<Vehicle> vehicles = vehicleRepository.findVehicleByCompanyAndDateInterval(optionalCompany.get(), flowCompanyVehicleForm.getDhStart(), flowCompanyVehicleForm.getDhEnd());
            return new FlowCompanyVehicleDto(optionalCompany.get(), vehicles);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código do estabelecimento não encontrado.");
    }
}
