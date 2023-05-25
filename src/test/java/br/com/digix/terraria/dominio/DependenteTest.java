package br.com.digix.terraria.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.terraria.builders.DependenteBuilder;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@SpringBootTest
public class DependenteTest {
    
    @Test
    void deve_cria_um_dependente() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        String nomeEsperado = "Lucas Martins";
        LocalDate dataDeNascimentoEsperada =  LocalDate.of(2010, 1, 5);

        Dependente dependente = new Dependente(nomeEsperado, dataDeNascimentoEsperada);

        assertThat(dependente.getNome()).isEqualTo(nomeEsperado);
        assertThat(dependente.getDataDeNascimento()).isEqualTo(dataDeNascimentoEsperada);
    }

    @Test
    void deve_construir_um_dependente_com_data_de_nascimento() throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid{
        String nomeEsperado = "Lucas Martins";
        LocalDate dataDeNascimentoEsperada =  LocalDate.of(2010, 1, 5);

        Dependente dependente = 
                    new DependenteBuilder()
                    .comNome(nomeEsperado)
                    .comDataDeNascimento(dataDeNascimentoEsperada)
                    .criar();

        assertThat(dependente.getNome()).isEqualTo(nomeEsperado);
        assertThat(dependente.getDataDeNascimento()).isEqualTo(dataDeNascimentoEsperada);
    }

    @Test
    void nao_deve_construir_um_dependente_sem_data_de_nascimento(){
        LocalDate dataDeNascimentoEsperada =  null;

        assertThrows(DataDeNascimentoInvalid.class,
        () ->{
            new DependenteBuilder()
                .comDataDeNascimento(dataDeNascimentoEsperada)
                .criar();
        });      
    }

    @Test
    void nao_deve_construir_um_dependente_sem_nome(){
        
    }
}
