package br.com.digix.terraria.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dependente extends Pessoa {

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    Dependente(String nome, LocalDate dataDeNascimento) {
        super(nome);
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public long getId() {
        return this.id;
    }
    
}
