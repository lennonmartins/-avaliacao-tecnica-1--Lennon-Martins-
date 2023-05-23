package br.com.digix.terraria.dominio;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriteriosMapper {
    public int validarSeAtendeCriterios(Familia familia);
}
