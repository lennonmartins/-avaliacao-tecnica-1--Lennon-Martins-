package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.dtos.responses.DependenteResponseDTO;

@SpringBootTest
public class DependenteServiceTest {

    @Autowired
    private DependenteService dependenteService;

    @Test
    void deve_cadastrar_um_dependente() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        DependenteRequestDTO dependenteRequestDTO = new DependenteRequestDTO("Esther","2010-07-19" );
        
        DependenteResponseDTO dependenteResponseDTO = dependenteService.cadastrarDependente(dependenteRequestDTO);
        
        assertThat(dependenteResponseDTO.getIdDoDependente()).isNotNull();
    }
}
