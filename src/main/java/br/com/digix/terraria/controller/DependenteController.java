package br.com.digix.terraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.dtos.responses.DependenteResponseDTO;
import br.com.digix.terraria.service.DependenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/dependentes" }, produces = { "application/json" })
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @Operation(summary = "Cadastra um novo dependente")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<DependenteResponseDTO> cadastrarDependente(@RequestBody @Valid DependenteRequestDTO novoDependente) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        return ResponseEntity.status(HttpStatus.CREATED).body(dependenteService.cadastrarDependente(novoDependente));
    }
}
