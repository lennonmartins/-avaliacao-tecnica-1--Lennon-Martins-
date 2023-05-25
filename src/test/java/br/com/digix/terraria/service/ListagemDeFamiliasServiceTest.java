package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.repository.FamiliaRepository;

@SpringBootTest
public class ListagemDeFamiliasServiceTest {
    
    @Autowired
    private ICriterios criteriosMapper;

    @Autowired
    private FamiliaRepository familiaRepository;

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

    @Test
    void deve_retornar_uma_lista_de_familias_ordenadas_pela_pontuacao() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException{
        int primeiraPosicao = 0;
        int ultimaPosicao = 5;
        int maiorPontuacao = 15; 
        int menorPontuacao = 0;
        ListagemDeFamiliasService lista = new ListagemDeFamiliasService();
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(5).criar());
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(10).criar());
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(maiorPontuacao).criar());
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(3).criar());
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(menorPontuacao).criar());
        lista.adicionarFamilia(new FamiliaBuilder().comPontos(13).criar());

        lista.ordernarFamiliasPelaPontuacao();

        assertThat(lista.listarFamilias().get(primeiraPosicao).getPontuacao()).isEqualTo(maiorPontuacao);
        assertThat(lista.listarFamilias().get(ultimaPosicao).getPontuacao()).isEqualTo(menorPontuacao);
    }
}