package br.com.digix.terraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.FamiliaRequestDTO;
import br.com.digix.terraria.dtos.responses.FamiliaResponseDTO;
import br.com.digix.terraria.service.FamiliaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/familias" }, produces = { "application/json" })
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;
    
    @Operation(summary = "Cadastra uma nova família")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<FamiliaResponseDTO> cadastrarFamilia(@RequestBody FamiliaRequestDTO novaFamilia) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException{
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.cadastraFamilia(novaFamilia));
    }

}
