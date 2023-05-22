package br.com.digix.terraria.dominio;

import java.util.List;

public class Familia implements Id{

    private long id;
    private int pontuação;
    private Conjuge conjuge;
    private Responsavel responsavel;
    private List<Dependente> dependentes;
    private Renda renda;



    @Override
    public long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }



    public String getResponsavel() {
        return null;
    }
    
}
