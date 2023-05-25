package br.com.digix.terraria.dominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@Entity
public class Conjuge extends Pessoa {

    @OneToOne
    @JoinColumn(name="familia_id")
    private Familia familia;
    
    public Conjuge(String nome) throws NomeInvalidException {
        super(nome);
    }

    public long getId() {
        return this.id;
    }
    
}
