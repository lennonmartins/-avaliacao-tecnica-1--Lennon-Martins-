package br.com.digix.terraria.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@DataJpaTest
public class FamiliaRepositoryTest {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    void deve_registra_umafamilia() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException{
        Familia familia = new FamiliaBuilder().criar();

        familiaRepository.save(familia);

        assertThat(familia.getId()).isNotNull();
    }

    @Test
    void deve_retornar_uma_lista_de_familias() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        int quantidadeDeFamiliasEsperada = 2;
        Familia familiaUm = new FamiliaBuilder().comDependente(new Dependente("Esther", LocalDate.of(2010, 7, 19))).criar();
        familiaRepository.save(familiaUm);
        Familia familiaDois = new FamiliaBuilder().criar();
        familiaRepository.save(familiaDois);

        Iterable<Familia> quantidadeDeFamlias =  familiaRepository.findAll();

        assertThat(quantidadeDeFamlias).isEqualTo(quantidadeDeFamiliasEsperada);
    }
}
