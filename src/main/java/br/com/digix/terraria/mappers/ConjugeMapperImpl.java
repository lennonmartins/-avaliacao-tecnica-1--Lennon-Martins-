package br.com.digix.terraria.mappers;

import org.springframework.stereotype.Component;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ConjugeRequestDTO;
import br.com.digix.terraria.dtos.responses.ConjugeResponseDTO;

@Component
public class ConjugeMapperImpl implements ConjugeMapper {

    @Override
    public ConjugeResponseDTO conjugeParaConjugeResponse(Conjuge conjuge) {
        return new ConjugeResponseDTO( conjuge.getNome(), conjuge.getId());
    }

    @Override
    public Conjuge conjugeRequestParaConjuge(ConjugeRequestDTO conjugeRequestDTO) throws NomeInvalidException {
        return new Conjuge(conjugeRequestDTO.getNomeDoConjuge());
    }
}
