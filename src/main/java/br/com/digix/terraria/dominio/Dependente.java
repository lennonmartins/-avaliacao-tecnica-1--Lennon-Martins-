package br.com.digix.terraria.dominio;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
public class Dependente extends Pessoa {

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="familia_id")
    private Familia familia;

    private final static int maiorIdade = 18;
    
    public Dependente(String nome, LocalDate dataDeNascimento) throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid {
        super(nome);
        validaDataDeNascimento(dataDeNascimento);
        validaSeDependenteEhMaisDezoito(dataDeNascimento);
        this.dataDeNascimento = dataDeNascimento;
    }
    
    private void validaSeDependenteEhMaisDezoito(LocalDate dataDeNascimento) throws DataNascimentoDependenteInvalid {
        int idadeDependente = (Period.between(dataDeNascimento, LocalDate.now())).getYears();
        if(idadeDependente > maiorIdade) throw new DataNascimentoDependenteInvalid();
    }

    private void validaDataDeNascimento(LocalDate dataDeNascimento) throws DataDeNascimentoInvalid {
        if(dataDeNascimento == null ) throw new DataDeNascimentoInvalid();
    }
}
