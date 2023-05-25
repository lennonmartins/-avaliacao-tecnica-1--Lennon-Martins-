package br.com.digix.terraria.mappers;

import org.mapstruct.Mapper;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.FamiliaRequestDTO;
import br.com.digix.terraria.dtos.responses.FamiliaResponseDTO;

@Mapper(componentModel = "spring")
public interface FamiliaMapper {
    Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException;
    FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia);
}
