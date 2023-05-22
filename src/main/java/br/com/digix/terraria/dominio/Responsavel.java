package br.com.digix.terraria.dominio;

import javax.persistence.Entity;

@Entity
public class Responsavel extends Pessoa {
    
    public Responsavel(String nome) throws NomeInvalidException{
        super(nome);
    }

    @Override
    public long getId() {
        return this.id;
    }

}
