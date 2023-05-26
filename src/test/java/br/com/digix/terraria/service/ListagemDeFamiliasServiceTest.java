package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@SpringBootTest
public class ListagemDeFamiliasServiceTest {

    ValidacaoDeCriterioService servico = new ValidacaoDeCriterioService();
    
    @Test
    void deve_retornar_uma_lista_de_familias() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException{
        int quantidadeDeFamiliaEsperada = 2;
        Familia familia1 = new FamiliaBuilder().criar();
        Familia familia2 = new FamiliaBuilder().criar();
        
        ListagemDeFamiliasService lista = new ListagemDeFamiliasService();
        lista.adicionarFamilia(familia1);
        lista.adicionarFamilia(familia2);

        assertThat(lista.listarFamilias().size()).isEqualTo(quantidadeDeFamiliaEsperada);
    }
}
