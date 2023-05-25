package br.com.digix.terraria.mappers;

import org.mapstruct.Mapper;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ConjugeRequestDTO;
import br.com.digix.terraria.dtos.responses.ConjugeResponseDTO;

@Mapper(componentModel = "spring")
public interface ConjugeMapper {
    ConjugeResponseDTO conjugeParaConjugeResponse(Conjuge conjuge);
    Conjuge conjugeRequestParaConjuge(ConjugeRequestDTO conjugeRequestDTO) throws NomeInvalidException;
}
