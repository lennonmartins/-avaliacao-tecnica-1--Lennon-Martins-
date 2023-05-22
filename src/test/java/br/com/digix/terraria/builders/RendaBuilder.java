package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.Renda;
import br.com.digix.terraria.dominio.RendaInvalidaException;

public class RendaBuilder {
    private double rendaMensal;

    public RendaBuilder(){
        this.rendaMensal = 900;
    }

    public Renda criar() throws RendaInvalidaException {
        return new Renda(rendaMensal);
    }

    public RendaBuilder comRenda(double renda) {
        this.rendaMensal = renda;
        return this;
    }

}
