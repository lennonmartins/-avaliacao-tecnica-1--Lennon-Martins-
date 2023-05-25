package br.com.digix.terraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dto.FamiliaRequestDTO;
import br.com.digix.terraria.dto.FamiliaResponseDTO;
import br.com.digix.terraria.mappers.FamiliaMapper;
import br.com.digix.terraria.repository.FamiliaRepository;
import br.com.digix.terraria.service.FamiliaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public ResponseEntity<FamiliaResponseDTO> cadastrarFamilia(@RequestBody FamiliaRequestDTO novaFamilia){
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.cadastraFamilia(novaFamilia));
        // return ResponseEntity.status(HttpStatus.CREATED).body(familiaRepository.save(novaFamilia));
    }


    // @Operation(summary = "Criar um novo pokemon")
    // @ApiResponse(responseCode = "201")
    // @PostMapping(consumes = { "application/json" })
    // public ResponseEntity<PokemonResponseDTO> criarPokemon(@RequestBody PokemonRequestDTO novoPokemon)
    //     throws NivelPokemonInvalidoException, FelicidadeInvalidaException, LimiteDeTipoPokemonException,
    //     LimiteDeAtaquePokemonException {
    //   return ResponseEntity
    //       .status(HttpStatus.CREATED)
    //       .body(pokemonService.criar(novoPokemon));
    // }
  

}
