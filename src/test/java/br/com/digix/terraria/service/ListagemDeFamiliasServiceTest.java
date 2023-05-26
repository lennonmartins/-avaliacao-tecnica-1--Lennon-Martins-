package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.FamiliaRequestDTO;
import br.com.digix.terraria.mappers.FamiliaMapper;
import br.com.digix.terraria.repository.ConjugeRepository;
import br.com.digix.terraria.repository.FamiliaRepository;
import br.com.digix.terraria.repository.ResponsavelRepository;

@SpringBootTest
public class ListagemDeFamiliasServiceTest {

    ValidacaoDeCriterioService servico = new ValidacaoDeCriterioService();

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ConjugeRepository conjugeRepository;

    @Autowired
    private FamiliaMapper familiaMapper;

    @BeforeEach
    @AfterEach
    public void deleteDados() {
        familiaRepository.deleteAll();
        responsavelRepository.deleteAll();
        conjugeRepository.deleteAll();
    };

    @Test
    void deve_retornar_uma_lista_de_familias() throws ResponsavelInvalidException, ConjugeInvalidException,
            DependentesInvalidException, NomeInvalidException {
        int quantidadeDeFamiliaEsperada = 2;
        Familia familia1 = new FamiliaBuilder().criar();
        Familia familia2 = new FamiliaBuilder().criar();

        ListagemDeFamiliasService lista = new ListagemDeFamiliasService();
        lista.adicionarFamilia(familia1);
        lista.adicionarFamilia(familia2);

        assertThat(lista.listarFamilias().size()).isEqualTo(quantidadeDeFamiliaEsperada);
    }

    @Test
    void deve_retornar_uma_lista_de_familias_ordenadas_pela_pontuacao() throws ResponsavelInvalidException,
            ConjugeInvalidException, DependentesInvalidException, NomeInvalidException {
        int pontuacaoEsperada = 5;
        ListagemDeFamiliasService lista = new ListagemDeFamiliasService();
        long idResponsavel = responsavelRepository.save(new Responsavel("Lennon")).getId();
        long idDoConjuge = conjugeRepository.save(new Conjuge("Maria")).getId();
        double rendaMensal = 850;
        FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTO(idDoConjuge, idResponsavel, null, rendaMensal);
        familiaRepository.save(familiaMapper.familiaRequestParaFamilia(familiaRequestDTO));
        List<Familia> familias = new ArrayList<>();
        familias.add(familiaRepository.save(familiaMapper.familiaRequestParaFamilia(familiaRequestDTO)));

        lista.ordernarFamiliasPelaPontuacao();

        assertThat(familias.get(0).getPontuacao()).isEqualTo(pontuacaoEsperada);
    }
}
