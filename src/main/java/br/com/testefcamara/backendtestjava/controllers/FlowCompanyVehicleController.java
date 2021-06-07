package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.FlowCompanyVehicleDto;
import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.form.FlowCompanyVehicleForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/flowCampanyVehicle")
public class FlowCompanyVehicleController {

    private final CompanyRepository companyRepository;

    private final VehicleRepository vehicleRepository;

    public FlowCompanyVehicleController(CompanyRepository companyRepository, VehicleRepository vehicleRepository) {
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping(value = "/{idCompany}")
    public Page<FlowCompanyVehicleDto> flowCampanyVehicle(@PathVariable Long idCompany, @RequestBody FlowCompanyVehicleForm flowCompanyVehicleForm, Pageable pageable) {
        Optional<Company> optionalCompany = companyRepository.findById(idCompany);
        if(optionalCompany.isPresent()){
            Page<Vehicle> vehicles = vehicleRepository.findVehicleByCompanyAndDateInterval(optionalCompany.get(), flowCompanyVehicleForm.getDhStart(), flowCompanyVehicleForm.getDhEnd(), pageable);
            return FlowCompanyVehicleDto.converter(vehicles);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código do estabelecimento não encontrado.");
    }
}
