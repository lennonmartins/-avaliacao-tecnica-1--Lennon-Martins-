package br.com.digix.terraria.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Renda implements Id{
    private double rendaMensal;
    private long id;
    private double rendaLimite = 1500;
    
    public Renda(double rendaMensal) throws RendaInvalidaException {
        validaRenda(rendaMensal);
        this.rendaMensal = rendaMensal;
    }

    @Override
    public long getId() {
        return this.id;
    }

    private void validaRenda(double renda) throws RendaInvalidaException{
        if(renda > rendaLimite){
            throw new RendaInvalidaException();
        }
    }
}
