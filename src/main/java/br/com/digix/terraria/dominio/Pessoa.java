package br.com.digix.terraria.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@MappedSuperclass
public abstract class Pessoa {
    
    @Column(nullable = false)
    private  String nome;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    Pessoa(String nome) throws NomeInvalidException{
        validaNome(nome);
        this.nome = nome;
    }

    private void validaNome(String nome) throws NomeInvalidException{
        if(nome == null || nome == "") throw new NomeInvalidException();
    }

    protected String getNome(){
        return this.nome;
    }
}
