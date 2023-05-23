package br.com.digix.terraria.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.FamiliaBuilder;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@SpringBootTest
public class ServicoTest {
    @Autowired
    private CriteriosMapper criteriosMapper;

    @Test
    void deve_validar_se_atende_aos_criterios() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException{
    Familia familia = new FamiliaBuilder().criar();
    Servico servico = new Servico(criteriosMapper);

    servico.validarOsCriteriosAtendidos(familia);

    assertThat(familia.getPontuacao()).isNotZero();
  }

}
