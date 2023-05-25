package br.com.digix.terraria.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

@Entity
public class Responsavel extends Pessoa {
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="familia_id")
    private Familia familia;
    
    public Responsavel(String nome, Familia familia) throws NomeInvalidException{
        super(nome);
        this.familia = familia;
    }

    public long getId() {
        return this.id;
    }

}
