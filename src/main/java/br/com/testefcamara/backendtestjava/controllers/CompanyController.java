package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.CompanyDto;
import br.com.testefcamara.backendtestjava.form.CompanyForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/company", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<CompanyDto> listAll(){
        List<Company> company = companyRepository.findAll();
        return CompanyDto.converter(company);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent())
            return ResponseEntity.ok(new CompanyDto(company.get()));
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado.");
    }

    @PostMapping(value="/register")
    @Transactional
    public ResponseEntity<CompanyDto> register(@RequestBody @Valid CompanyForm companyForm, UriComponentsBuilder uriBuilder){
        Company company = companyForm.converter();
        companyRepository.save(company);
        URI uri = uriBuilder.path("/registerCompany/{id}").buildAndExpand(company.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompanyDto(company));
    }

    @PutMapping(value= "/update/{id}")
    @Transactional
    public ResponseEntity<CompanyDto> update(@PathVariable Long id, @RequestBody @Valid CompanyForm companyForm) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = companyForm.update(id, companyRepository);
            return ResponseEntity.ok(new CompanyDto(company));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value="/delete/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            companyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
