package br.com.digix.terraria.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.terraria.dtos.responses.ListagemResponseDTO;
import br.com.digix.terraria.service.ListagemDeFamiliasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/Listagem" }, produces = { "application/json" })
public class ListagemDeFamiliasController {

    @Autowired
    private ListagemDeFamiliasService listagemDeFamiliasService;

    @Operation(summary ="Buscar uma lista de familias ordenada pelo critério de maior pontuação")
    @ApiResponse(responseCode = "200", description = "Retorna uma lista de família solicitada" )
    @GetMapping
    public ResponseEntity<Collection<ListagemResponseDTO>> listarFamilias() {
        return ResponseEntity.ok(listagemDeFamiliasService.ordernarFamiliasPelaPontuacao());
    }
}
