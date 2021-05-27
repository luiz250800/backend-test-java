package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.VehicleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class VehicleController {

    @RequestMapping("/vehicle")
    public List<VehicleDto> listAll(){
        return VehicleDto.converter(Arrays.asList());
    }
}
