package br.com.digix.terraria.dominio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.builders.ResponsavelBuilder;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;

@SpringBootTest
public class FamiliaTest {
    
    @Test
    void deve_criar_uma_familia_com_responsavel(){
        String nomeResponsavelEsperado = "Lennon";
        Responsavel responsavel = new ResponsavelBuilder(nomeResponsavelEsperado).criar();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).Criar();

        Assertions.assertThat(familia.getResponsavel()).isEqualTo(nomeResponsavelEsperado);
        }
}
