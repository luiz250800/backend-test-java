package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.CompanyDto;
import br.com.testefcamara.backendtestjava.form.CompanyForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<CompanyDto> listAll(){
        List<Company> company = companyRepository.findAll();
        return CompanyDto.converter(company);
    }

    @RequestMapping(value="/find", method = RequestMethod.GET)
    public List<CompanyDto> findByNmCompany(@Param("nmCompany") String nmCompany){
        List<Company> company = companyRepository.findByNmCompany(nmCompany);
        return CompanyDto.converter(company);
    }

    @RequestMapping(value="/registerCompany", method = RequestMethod.POST)
    public void registarCompany(@RequestBody CompanyForm companyForm){
        Company company = companyForm.converter();
        companyRepository.save(company);
    }
}
