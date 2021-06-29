package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.FlowCompanyVehicleDto;
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

/**
 * Classe controller para fluxo de veículo.
 */
@RestController
@RequestMapping(value = "/api/flowCampanyVehicle", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class FlowCompanyVehicleController {

    private final CompanyRepository companyRepository;

    private final VehicleRepository vehicleRepository;

    /**
     * @param companyRepository
     * @param vehicleRepository
     */
    public FlowCompanyVehicleController(CompanyRepository companyRepository, VehicleRepository vehicleRepository) {
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Método para geração de relatório de entrada e saida de veículos para uma determinada empresa.
     * @param idCompany
     * @param flowCompanyVehicleForm
     * @return
     */
    @GetMapping(value = "/{idCompany}")
    public ResponseEntity<FlowCompanyVehicleDto> flowCampanyVehicle(@PathVariable Long idCompany, @RequestBody FlowCompanyVehicleForm flowCompanyVehicleForm) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(idCompany);
            if(!optionalCompany.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado.");
            List<Vehicle> vehicles = vehicleRepository.findVehicleByCompanyAndDateInterval(optionalCompany.get(), flowCompanyVehicleForm.getDhStart(), flowCompanyVehicleForm.getDhEnd());
            return new ResponseEntity(new FlowCompanyVehicleDto(optionalCompany.get(), vehicles), HttpStatus.OK);
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }
}
