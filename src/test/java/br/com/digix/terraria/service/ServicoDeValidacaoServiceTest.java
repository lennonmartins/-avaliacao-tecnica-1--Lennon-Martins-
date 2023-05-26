package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.DependenteBuilder;
import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.FamiliaRequestDTO;
import br.com.digix.terraria.mappers.FamiliaMapper;
import br.com.digix.terraria.repository.ConjugeRepository;
import br.com.digix.terraria.repository.FamiliaRepository;
import br.com.digix.terraria.repository.ResponsavelRepository;

@SpringBootTest
public class ServicoDeValidacaoServiceTest {

  @Autowired
  private ValidacaoDeCriterioService servicoDeValidacao;

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
  void deve_validar_se_atende_aos_criterios()
      throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException,
      DataDeNascimentoInvalid, DataNascimentoDependenteInvalid {
    int pontuacaoEsperada = 7;
    Dependente dependente = new DependenteBuilder().comDataDeNascimento(LocalDate.of(2010, 7, 19)).criar();
    Familia familia = new FamiliaBuilder().comDependente(dependente).criar();

    List<Familia> listaDeFamilia = new ArrayList<>();
    listaDeFamilia.add(familia);

    servicoDeValidacao.validarOsCriteriosAtendidos(listaDeFamilia);

    assertThat(familia.getPontuacao()).isEqualTo(pontuacaoEsperada);
  }

  @Test
  void deve_pontuar_a_familia_de_acordo_com_o_criterio()
      throws NomeInvalidException, ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
    int pontuacaoEsperada = 5;
    long idResponsavel = responsavelRepository.save(new Responsavel("Lennon")).getId();
    long idDoConjuge = conjugeRepository.save(new Conjuge("Maria")).getId();
    double rendaMensal = 850;
    FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTO(idDoConjuge, idResponsavel, null, rendaMensal);
    familiaRepository.save(familiaMapper.familiaRequestParaFamilia(familiaRequestDTO));

    List<Familia> familias = servicoDeValidacao.pontuarFamiliaPelosCriteriosAtendidos();

    assertThat(familias.get(0).getPontuacao()).isEqualTo(pontuacaoEsperada);
  }
}
