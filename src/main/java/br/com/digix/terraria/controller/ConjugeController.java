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
import br.com.digix.terraria.dtos.requests.ConjugeRequestDTO;
import br.com.digix.terraria.dtos.responses.ConjugeResponseDTO;
import br.com.digix.terraria.service.ConjugeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/conjuges" }, produces = { "application/json" })
public class ConjugeController {
    
    @Autowired
    private ConjugeService conjugeService;

    @Operation(summary = "Cadastra um novo conjuge")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<ConjugeResponseDTO> cadastrarConjuge(@RequestBody @Valid ConjugeRequestDTO novoConjuge) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        return ResponseEntity.status(HttpStatus.CREATED).body(conjugeService.cadastrarConjuge(novoConjuge));
    }
}
