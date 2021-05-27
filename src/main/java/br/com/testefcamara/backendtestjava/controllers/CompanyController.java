package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.CompanyDto;
import br.com.testefcamara.backendtestjava.models.Company;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CompanyController {

    @RequestMapping("/company")
    public List<CompanyDto> listAll(){
        return CompanyDto.converter(Arrays.asList());
    }
}
