package br.com.digix.terraria.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.terraria.builders.RendaBuilder;
import br.com.digix.terraria.dominio.Renda;

@DataJpaTest
public class RendaRepositoryTest {
    
    @Autowired
    private RendaRepository rendaRepository;

    @Test
    void deve_registar_uma_renda(){
        Renda renda = new RendaBuilder().criar();

        rendaRepository.save(renda);

        Assertions.assertThat(renda.getId()).isNotNull();
    }
}
