package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.bo.FlowVehicleCompanyBo;
import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.form.*;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/vehicle", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    private final CompanyRepository companyRepository;

    public VehicleController(VehicleRepository vehicleRepository, CompanyRepository companyRepository) {
        this.vehicleRepository = vehicleRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent())
            return ResponseEntity.ok(new VehicleDto(vehicle.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/register")
    @Transactional
    public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm vehicleForm, UriComponentsBuilder uriBuilder) {
        Vehicle vehicle = vehicleForm.converter(companyRepository);
        Vehicle vehicleSave = vehicleRepository.save(vehicle);

        FlowVehicleCompanyBo.registerEntranceVehicleCompany(companyRepository, vehicleForm.getIdCompany(), vehicleSave.getTpVehicle());

        URI uri = uriBuilder.path("/register/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
    }

    @PutMapping(value = "/update/{id}")
    @Transactional
    public ResponseEntity<VehicleDto> update(@PathVariable Long id, @RequestBody @Valid VehicleUpdateForm vehicleForm) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = vehicleForm.update(id, vehicleRepository);
            return ResponseEntity.ok(new VehicleDto(vehicle));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            FlowVehicleCompanyBo.registerOutputVehicleCompany(companyRepository, optionalVehicle.get().getCompany().getId(), optionalVehicle.get().getTpVehicle());
            Vehicle vehicle = VehicleDeleteForm.deletedAt(id, vehicleRepository);
            return ResponseEntity.ok(new VehicleDto(vehicle));
        }
        return ResponseEntity.notFound().build();
    }
}
