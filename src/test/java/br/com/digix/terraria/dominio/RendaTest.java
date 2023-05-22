package br.com.digix.terraria.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.RendaBuilder;

@SpringBootTest
public class RendaTest {
 
    @Test
    void deve_construir_uma_renda() throws RendaInvalidaException{
        double rendaMensalEsperada = 900;

        Renda renda = new Renda(rendaMensalEsperada);

        assertThat(renda.getRendaMensal()).isEqualTo(rendaMensalEsperada);
    }

    @Test
    void deve_criar_uma_renda() throws RendaInvalidaException{
        double rendaMensalEsperada = 1500;

        Renda renda = 
            new RendaBuilder()
                .comRenda(rendaMensalEsperada)
                .criar();

        assertThat(renda.getRendaMensal()).isEqualTo(rendaMensalEsperada);
    }

    @Test
    void deve_cronstruir_uma_renda_dentro_o_limite() throws RendaInvalidaException{
        double rendaMensalEsperada = 1500;
        
        Renda rendaMensal = 
            new RendaBuilder()
                .comRenda(rendaMensalEsperada)
                .criar();

        assertThat(rendaMensal.getRendaMensal()).isEqualTo(rendaMensalEsperada);
    }

    @Test
    void nao_deve_criar_uma_renda_fora_do_limite(){
        double rendaMensalEsperada = 1501;

        assertThrows(RendaInvalidaException.class,
        () -> {
            new RendaBuilder()
                .comRenda(rendaMensalEsperada)
                .criar();
        });        
    }
    
}
