package br.com.digix.terraria.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.DependenteBuilder;
import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@SpringBootTest
public class ServicoDeValidacaoServiceTest {

  @Autowired
  private ValidacaoDeCriterioService servicoDeValidacao;

  @Test
  void deve_validar_se_atende_aos_criterios()
      throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid {
    int pontuacaoEsperada = 7;
    Dependente dependente = new DependenteBuilder().comDataDeNascimento(LocalDate.of(2010, 7, 19)).criar();
    Familia familia = new FamiliaBuilder().comDependente(dependente).criar();

    List<Familia> listaDeFamilia = new ArrayList<>();
    listaDeFamilia.add(familia);

    servicoDeValidacao.validarOsCriteriosAtendidos(listaDeFamilia);

    assertThat(familia.getPontuacao()).isEqualTo(pontuacaoEsperada);
  }
}
