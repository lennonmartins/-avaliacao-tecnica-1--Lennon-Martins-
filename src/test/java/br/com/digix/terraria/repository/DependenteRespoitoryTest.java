package br.com.digix.terraria.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.terraria.builders.DependenteBuilder;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@DataJpaTest
public class DependenteRespoitoryTest {
    
    @Autowired
    private DependenteRepository dependenteRepository;

    @Test
    void deve_registrar_um_dependente() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
    Dependente dependente = new DependenteBuilder().criar();

    dependenteRepository.save(dependente);

    Assertions.assertThat(dependente.getId()).isNotNull();    
    }

}
