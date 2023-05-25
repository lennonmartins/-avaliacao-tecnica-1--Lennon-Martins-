package br.com.digix.terraria.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.RendaBuilder;

@SpringBootTest
public class RendaTest {
 
    @Test
    void deve_construir_uma_renda() {
        double rendaMensalEsperada = 900;

        Renda renda = new Renda(rendaMensalEsperada);

        assertThat(renda.getRendaMensal()).isEqualTo(rendaMensalEsperada);
    }

    @Test
    void deve_criar_uma_renda()  {
        double rendaMensalEsperada = 1500;

        Renda renda = 
            new RendaBuilder()
                .comRenda(rendaMensalEsperada)
                .criar();

        assertThat(renda.getRendaMensal()).isEqualTo(rendaMensalEsperada);
    }
}
