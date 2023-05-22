package br.com.digix.terraria.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.ConjugeBuilder;
import br.com.digix.terraria.builders.DependenteBuilder;
import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.builders.RendaBuilder;
import br.com.digix.terraria.builders.ResponsavelBuilder;

@SpringBootTest
public class FamiliaTest {

  @Test
  void deve_criar_uma_familia() throws NomeInvalidException, DataDeNascimentoInvalid, ResponsavelInvalidException,
      ConjugeInvalidException, DependentesInvalidException {
    String nomeResponsavelEsperado = "Lennon";
    Responsavel responsavel = new ResponsavelBuilder().comNome(nomeResponsavelEsperado).criar();
    String nomeConjugeEsperado = "Miguel";
    Conjuge conjuge = new ConjugeBuilder().comNome(nomeConjugeEsperado).criar();
    double rendaMensalEsperada = 900;
    Renda rendaMensal = new RendaBuilder().comRenda(rendaMensalEsperada).criar();
    List<Dependente> dependentes = new ArrayList<>();
    dependentes.add(new DependenteBuilder().criar());

    Familia familia = new Familia(conjuge, responsavel, dependentes, rendaMensal);

    assertThat(familia.getResponsavel().getNome()).isEqualTo(nomeResponsavelEsperado);
    assertThat(familia.getConjuge().getNome()).isEqualTo(nomeConjugeEsperado);
    assertThat(familia.getRendaMensal().getRendaMensal()).isEqualTo(rendaMensalEsperada);
    assertThat(familia.getDependentes()).isNotEmpty();
  }

  @Test
  void deve_cadastrar_uma_familia_com_tres_dependetes() throws NomeInvalidException, DataDeNascimentoInvalid,
      ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
    int quantidadeDeDependentesEsperada = 3;

    Familia familia = new FamiliaBuilder()
        .comDependente(new DependenteBuilder().criar())
        .comDependente(new DependenteBuilder().criar())
        .comDependente(new DependenteBuilder().criar())
        .criar();

    assertThat(familia.getDependentes().size()).isEqualTo(quantidadeDeDependentesEsperada);
  }

  @Test
  void nao_deve_cadastrar_uma_familia_sem_responsavel() {
    Responsavel responsavelInvalido = null;

    assertThrows(ResponsavelInvalidException.class,
        () -> {
          new FamiliaBuilder()
              .comResponsavel(responsavelInvalido)
              .criar();
        });
  }

  @Test
  void nao_deve_cadastrar_uma_familia_sem_conjuge() {
    Conjuge conjugeInvalido = null;

    assertThrows(ConjugeInvalidException.class,
        () -> {
          new FamiliaBuilder()
              .comConjuge(conjugeInvalido)
              .criar();
        });
  }

  @Test
  void nao_deve_cadastrar_uma_familia_sem_dependentes() {
    // List <Dependente> dependentes = new ArrayList<>();
    Dependente dependente = null;

    assertThrows(DependentesInvalidException.class,
        () -> {
          new FamiliaBuilder()
              .comDependente(dependente)
              .criar();
        });
  }
}
