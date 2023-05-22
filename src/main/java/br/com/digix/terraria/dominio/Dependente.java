package br.com.digix.terraria.dominio;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dependente extends Pessoa {

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    public Dependente(String nome, LocalDate dataDeNascimento) throws NomeInvalidException, DataDeNascimentoInvalid {
        super(nome);
        validaDataDeNsacimento(dataDeNascimento);
        this.dataDeNascimento = dataDeNascimento;
    }

    private void validaDataDeNsacimento(LocalDate dataDeNascimento) throws DataDeNascimentoInvalid {
        if(dataDeNascimento == null ) throw new DataDeNascimentoInvalid();
    }

    @Override
    public long getId() {
        return this.id;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }
    
}
