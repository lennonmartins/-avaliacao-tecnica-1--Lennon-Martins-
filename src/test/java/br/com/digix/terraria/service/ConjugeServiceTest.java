package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ConjugeRequestDTO;
import br.com.digix.terraria.dtos.responses.ConjugeResponseDTO;

@SpringBootTest
public class ConjugeServiceTest {

    @Autowired
    private ConjugeService conjugeService;

    @Test
    void deve_cadastrar_um_conjuge() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        ConjugeRequestDTO conjugeRequestDTO = new ConjugeRequestDTO("Lennon");
        
        ConjugeResponseDTO conjugeResponseDTO = conjugeService.cadastrarConjuge(conjugeRequestDTO);
        
        assertThat(conjugeResponseDTO.getIdConjuge()).isNotNull();
    }
}
