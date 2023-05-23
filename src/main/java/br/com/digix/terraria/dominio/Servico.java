package br.com.digix.terraria.dominio;

public class Servico {
    private CriteriosMapper criteriosMapper;

    public Servico( CriteriosMapper criteriosMapper){
        this.criteriosMapper = criteriosMapper; 
    }
    
    public void validarOsCriteriosAtendidos(Familia familia){
        familia.adicionarPontos(this.criteriosMapper.validarSeAtendeCriterios(familia));
    }

    
}
