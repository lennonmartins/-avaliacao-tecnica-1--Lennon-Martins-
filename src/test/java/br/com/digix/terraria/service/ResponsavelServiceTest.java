package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ResponsavelRequestDTO;
import br.com.digix.terraria.dtos.responses.ResponsavelResponseDTO;

@SpringBootTest
public class ResponsavelServiceTest {

    @Autowired
    private ResponsavelService responsavelService;

    @Test
    void deve_cadastrar_um_responsavel() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        ResponsavelRequestDTO responsavelRequestDTO = new ResponsavelRequestDTO("Esther" );
        
        ResponsavelResponseDTO responsavelResponseDTO = responsavelService.cadastrarResponsavel(responsavelRequestDTO);
        
        assertThat(responsavelResponseDTO.getIdResponsavel()).isNotNull();
    }
}
