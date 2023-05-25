package br.com.digix.terraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Familia;

@Service
public class ValidacaoDeCriterioService {

    @Autowired
    private ICriterios criteriosMapper;
    
    public void validarOsCriteriosAtendidos(List<Familia> familias){
        this.criteriosMapper.validarSeAtendeCriterios(familias);
    }

    // private void adicionarPontos(int pontos){
    //     this.familia.setPontos(pontos) ;
    // }
    
}
