package br.com.digix.terraria.dominio;

import javax.persistence.Column;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;


public abstract class Pessoa implements Id {
    
    @Column(nullable = false)
    private  String nome;

    @Column(nullable = false)
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
