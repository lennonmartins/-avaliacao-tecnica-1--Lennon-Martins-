package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;

public class FamiliaBuilder {

    private Responsavel responsavel = new Responsavel("Lennon");

    public FamiliaBuilder comResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public Familia Criar() {
        return new Familia();
    }

}
