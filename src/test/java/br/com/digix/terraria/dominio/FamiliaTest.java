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
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@SpringBootTest
public class FamiliaTest {
    
   
  @Test
  void deve_criar_uma_familia() throws NomeInvalidException, DataDeNascimentoInvalid, ResponsavelInvalidException,
      ConjugeInvalidException, DependentesInvalidException, DataNascimentoDependenteInvalid {
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
      ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, DataNascimentoDependenteInvalid {
    int quantidadeDeDependentesEsperada = 3;

    Familia familia = new FamiliaBuilder()
        .comDependente(new DependenteBuilder().criar())
        .comDependente(new DependenteBuilder().criar())
        .comDependente(new DependenteBuilder().criar())
        .criar();

    assertThat(familia.getDependentes().size()).isEqualTo(quantidadeDeDependentesEsperada);
  }

  @Test
  void deve_cadastra_uma_familia_sem_dependentes() throws ResponsavelInvalidException, ConjugeInvalidException, NomeInvalidException, DependentesInvalidException{

    Familia familia = new FamiliaBuilder()
        .criar(); 

      assertThat(familia.getDependentes().size()).isZero();
  }

//   @Test
//   void deve_cadastra_uma_familia_com_dependentes_nulos() throws ResponsavelInvalidException, ConjugeInvalidException, NomeInvalidException, DependentesInvalidException{

//     Familia familia = new FamiliaBuilder()
//         .comDependente(null)
//         .criar(); 

//       assertThat(familia.getDependentes().size()).isZero();
//   }

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
}
