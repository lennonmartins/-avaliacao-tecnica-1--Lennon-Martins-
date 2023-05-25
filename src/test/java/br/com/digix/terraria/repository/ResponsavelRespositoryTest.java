package br.com.digix.terraria.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.terraria.builders.ResponsavelBuilder;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@DataJpaTest
public class ResponsavelRespositoryTest {

    @Autowired
    private ResponsavelRepository responsavelRepository;
    
    @Test
    void deve_registrar_um_responsavel() throws NomeInvalidException, ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException{
        
        Responsavel responsavel = new ResponsavelBuilder().criar();

        responsavelRepository.save(responsavel);
        
        Assertions.assertThat(responsavel.getId()).isNotNull();
    }
}
