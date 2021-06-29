package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.bo.FlowVehicleCompanyBo;
import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.form.*;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

/**
 * Classe controller para CRUD de veículo.
 */
@RestController
@RequestMapping(value = "/api/vehicle", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    private final CompanyRepository companyRepository;

    /**
     * @param vehicleRepository
     * @param companyRepository
     */
    public VehicleController(VehicleRepository vehicleRepository, CompanyRepository companyRepository) {
        this.vehicleRepository = vehicleRepository;
        this.companyRepository = companyRepository;
    }

    /**
     * Método para busca de veículo com determinado ID.
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable Long id) {
        try {
            Optional<Vehicle> vehicle = vehicleRepository.findById(id);
            if (!vehicle.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado.");
            return ResponseEntity.ok(new VehicleDto(vehicle.get()));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para registro de novo veículo.
     * @param vehicleForm
     * @param uriBuilder
     * @return
     */
    @PostMapping(value = "/register")
    @Transactional
    public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm vehicleForm, UriComponentsBuilder uriBuilder) {
        try {
            Vehicle vehicle = vehicleForm.converter(companyRepository);
            Vehicle vehicleSave = vehicleRepository.save(vehicle);
            FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, vehicleForm.getIdCompany(), vehicleSave.getTpVehicle());
            URI uri = uriBuilder.path("/register/{id}").buildAndExpand(vehicle.getId()).toUri();
            return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para alteração um veículo.
     * @param id
     * @param vehicleForm
     * @return
     */
    @PutMapping(value = "/update/{id}")
    @Transactional
    public ResponseEntity<VehicleDto> update(@PathVariable Long id, @RequestBody @Valid VehicleUpdateForm vehicleForm) {
        try {
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
            if (!optionalVehicle.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado.");
            Vehicle vehicle = vehicleForm.update(id, vehicleRepository);
            return ResponseEntity.ok(new VehicleDto(vehicle));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para exclusão de veículo.
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    @Transactional
    public ResponseEntity<VehicleDto> delete(@PathVariable Long id) {
        try {
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
            if (!optionalVehicle.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado.");
            FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, optionalVehicle.get().getCompany().getId(), optionalVehicle.get().getTpVehicle());
            Vehicle vehicle = VehicleDeleteForm.deletedAt(id, vehicleRepository);
            return ResponseEntity.ok(new VehicleDto(vehicle));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }
}
