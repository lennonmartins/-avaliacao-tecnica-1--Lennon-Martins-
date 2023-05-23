package br.com.digix.terraria.dominio;

public class CriteriosMapperImplDois implements CriteriosMapper {

    @Override
    public int validarSeAtendeCriterios(Familia familia) {
        double rendaFamilia = familia.getRendaMensal().getRendaMensal();
        if(rendaFamilia > 900 && rendaFamilia <= 1500 ) return +3;
        return 0;
    }
}
