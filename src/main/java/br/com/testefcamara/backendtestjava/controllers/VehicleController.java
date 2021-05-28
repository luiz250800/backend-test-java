package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import br.com.testefcamara.backendtestjava.form.VehicleForm;
import br.com.testefcamara.backendtestjava.models.Vehicle;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import br.com.testefcamara.backendtestjava.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<VehicleDto> listAll(){
        List<Vehicle> vehicle = vehicleRepository.findAll();
        return VehicleDto.converter(vehicle);
    }

    @GetMapping(value = "/{id}")
    public VehicleDto findById (@PathVariable Long id) {
        Vehicle vehicle = vehicleRepository.getById(id);
        return new VehicleDto(vehicle);
    }

    @PostMapping(value="/register")
    public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm vehicleForm, UriComponentsBuilder uriBuilder){
        Vehicle vehicle = vehicleForm.converter(companyRepository);
        vehicleRepository.save(vehicle);
        URI uri = uriBuilder.path("/register/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
    }
}
