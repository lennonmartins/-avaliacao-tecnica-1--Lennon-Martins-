package br.com.digix.terraria.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.ResponsavelBuilder;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@SpringBootTest
public class ResponsavelTest {
    
    @Test
    void  deve_construir_um_responsavel() throws NomeInvalidException, ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException{
        String nomeEsperado = "Lennon";
        
        Responsavel responsavel = new Responsavel(nomeEsperado);
        
        assertEquals(nomeEsperado, responsavel.getNome());
    }

    @Test
    void deve_registrar_um_responsavel() throws NomeInvalidException, ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException{
        String nomeEsperado = "Miguel";
        
        Responsavel responsavel = 
            new ResponsavelBuilder()
                .comNome(nomeEsperado)
                .criar();

        assertEquals(nomeEsperado, responsavel.getNome());
    }

    @Test
    void não_deve_registrar_um_responsavel_com_nome_vazio(){
        String nomeEsperado = "";

        assertThrows(
            NomeInvalidException.class,
            () -> {
                new ResponsavelBuilder()
                    .comNome(nomeEsperado)
                    .criar();
            });
    }

    @Test
    void não_deve_registrar_um_responsavel_com_nome_nulo(){
        String nomeEsperado = null;

        assertThrows(
            NomeInvalidException.class,
            () -> {
                new ResponsavelBuilder()
                    .comNome(nomeEsperado)
                    .criar();
            });
    }
}
