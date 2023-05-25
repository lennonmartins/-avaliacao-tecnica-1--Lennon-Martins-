package br.com.digix.terraria.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.terraria.builders.ConjugeBuilder;
import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@DataJpaTest
public class ConjugeRespositoryTest {
    
    @Autowired
    private ConjugeRepository conjugeRepository;

    @Test
    void deve_registar_uma_conjuge() throws NomeInvalidException{
        Conjuge conjuge = new ConjugeBuilder().criar();

        conjugeRepository.save(conjuge);

        Assertions.assertThat(conjuge.getId()).isNotNull();
    }
}
