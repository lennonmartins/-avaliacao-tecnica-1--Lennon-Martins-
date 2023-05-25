package br.com.digix.terraria.mappers;

import org.mapstruct.Mapper;

import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dtos.responses.ResponsavelResponseDTO;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper {
    ResponsavelResponseDTO responsavelParaResponsavelResponse(Responsavel responsavel);
}
