package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.dto.CompanyDto;
import br.com.testefcamara.backendtestjava.form.CompanyForm;
import br.com.testefcamara.backendtestjava.models.Company;
import br.com.testefcamara.backendtestjava.repository.CompanyRepository;
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

/**
 * Classe controller para CRUD de estabelecimento.
 */
@RestController
@RequestMapping(value = "/api/company", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Método para listagem de todos os estabelecimentos cadastrados.
     * @return
     */
    @GetMapping
    public List<CompanyDto> listAll(){
        try {
            List<Company> company = companyRepository.findAll();
            return CompanyDto.converter(company);
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para busca de estabelecimento com determinado ID.
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable Long id) {
        try {
            Optional<Company> company = companyRepository.findById(id);
            if(!company.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado.");
            return ResponseEntity.ok(new CompanyDto(company.get()));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para registro de novo estabelecimento.
     * @param companyForm
     * @param uriBuilder
     * @return
     */
    @PostMapping(value="/register")
    @Transactional
    public ResponseEntity<CompanyDto> register(@RequestBody @Valid CompanyForm companyForm, UriComponentsBuilder uriBuilder){
        try {
            Company company = companyForm.converter();
            companyRepository.save(company);
            URI uri = uriBuilder.path("/registerCompany/{id}").buildAndExpand(company.getId()).toUri();
            return ResponseEntity.created(uri).body(new CompanyDto(company));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para alteração um estabelecimento.
     * @param id
     * @param companyForm
     * @return
     */
    @PutMapping(value= "/update/{id}")
    @Transactional
    public ResponseEntity<CompanyDto> update(@PathVariable Long id, @RequestBody @Valid CompanyForm companyForm) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(id);
            if(!optionalCompany.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado.");
            Company company = companyForm.update(id, companyRepository);
            return ResponseEntity.ok(new CompanyDto(company));
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para exclusão de estabelecimento.
     * @param id
     * @return
     */
    @DeleteMapping(value="/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            Optional<Company> optionalCompany = companyRepository.findById(id);
            if(!optionalCompany.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado.");
            companyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

}
