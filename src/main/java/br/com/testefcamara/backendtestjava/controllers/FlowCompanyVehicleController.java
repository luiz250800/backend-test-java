package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.FlowCompanyVehicleDto;
import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.errorDto.ErrorDto;
import br.com.testefcamara.backendtestjava.form.FlowCompanyVehicleForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FlowCompanyVehicleDto> flowCampanyVehicle(@PathVariable Long idCompany, @RequestBody FlowCompanyVehicleForm flowCompanyVehicleForm) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(idCompany);
            if(!optionalCompany.isPresent())
                return new ResponseEntity(new ErrorDto(404, "Estabelecimento não encontrado."), HttpStatus.NOT_FOUND);
            List<Vehicle> vehicles = vehicleRepository.findVehicleByCompanyAndDateInterval(optionalCompany.get(), flowCompanyVehicleForm.getDhStart(), flowCompanyVehicleForm.getDhEnd());
            return new ResponseEntity(new FlowCompanyVehicleDto(optionalCompany.get(), vehicles), HttpStatus.OK);
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }
}
