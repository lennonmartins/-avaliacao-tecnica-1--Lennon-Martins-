package br.com.digix.terraria.dominio;

import org.springframework.stereotype.Component;

@Component
public class CriteriosMapperImpl implements CriteriosMapper {

    @Override
    public int validarSeAtendeCriterios(Familia familia) {
        if(familia.getRendaMensal().getRendaMensal() <= 900) return +5;
        return 0;
    }    
}
