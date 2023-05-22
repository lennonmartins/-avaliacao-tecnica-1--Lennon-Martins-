package br.com.digix.terraria.builders;

import java.time.LocalDate;

import br.com.digix.terraria.dominio.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.NomeInvalidException;

public class DependenteBuilder {

    private LocalDate dataDeNascimento;
    private String nomeDependente;

    public DependenteBuilder() {
        this.nomeDependente = "Thiago Flores"; 
        this.dataDeNascimento = LocalDate.of(2015, 5, 21);
    }

    public DependenteBuilder comDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public Dependente criar() throws NomeInvalidException, DataDeNascimentoInvalid{
        return new Dependente(nomeDependente, dataDeNascimento);
    }

    public DependenteBuilder comNome(String nome) {
        this.nomeDependente = nome;
        return this;
    }

}
