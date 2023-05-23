package br.com.digix.terraria.dominio;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

public class Conjuge extends Pessoa {
    
    public Conjuge(String nome) throws NomeInvalidException {
        super(nome);
    }

    @Override
    public long getId() {
        return this.id;
    }
    
}
