package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.Renda;

public class RendaBuilder {
    private double rendaMensal;

    public RendaBuilder(){
        this.rendaMensal = 900;
    }
 
    public RendaBuilder comRenda(double renda) {
        this.rendaMensal = renda;
        return this;
    }
    
    public Renda criar() {
        return new Renda(rendaMensal);
    }
}
