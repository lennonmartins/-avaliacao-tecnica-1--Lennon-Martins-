package br.com.digix.terraria.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.ConjugeBuilder;

@SpringBootTest
public class ConjugeTest {
    
    @Test
    void deve_construir_um_conjuge() throws NomeInvalidException{
        String nome = "João Carlos";

        Conjuge conjuge = new Conjuge(nome);

        Assertions.assertThat(nome).isEqualTo(conjuge.getNome());
    }

    @Test
    void não_deve_registrar_um_conjuge_com_nome_vazio(){
        String nomeEsperado = "";

        assertThrows(
            NomeInvalidException.class,
            () -> {
                new ConjugeBuilder()
                    .comNome(nomeEsperado)
                    .criar();
            });
    }

    @Test
    void não_deve_registrar_um_conjuge_com_nome_nulo(){
        String nomeEsperado = null;

        assertThrows(
            NomeInvalidException.class,
            () -> {
                new ConjugeBuilder()
                    .comNome(nomeEsperado)
                    .criar();
            });
    }
}
