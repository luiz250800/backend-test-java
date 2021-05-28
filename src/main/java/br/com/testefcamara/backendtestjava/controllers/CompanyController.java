package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.CompanyDto;
import br.com.testefcamara.backendtestjava.form.CompanyForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @RequestMapping(value="/{nmCompany}", method = RequestMethod.GET)
    public List<CompanyDto> findByNmCompanyLike(@PathVariable("nmCompany") String nmCompany){
        List<Company> company = companyRepository.findByNmCompanyLike(nmCompany);
        return CompanyDto.converter(company);
    }

    @RequestMapping(value="/registerCompany", method = RequestMethod.POST)
    public ResponseEntity<CompanyDto> registerCompany(@RequestBody @Valid CompanyForm companyForm, UriComponentsBuilder uriBuilder){
        Company company = companyForm.converter();
        companyRepository.save(company);
        URI uri = uriBuilder.path("/registerCompany/{id}").buildAndExpand(company.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompanyDto(company));
    }
}
