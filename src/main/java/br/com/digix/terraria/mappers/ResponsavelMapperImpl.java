package br.com.digix.terraria.mappers;

import org.springframework.stereotype.Component;

import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dtos.responses.ResponsavelResponseDTO;

@Component
public class ResponsavelMapperImpl implements ResponsavelMapper {

    @Override
    public ResponsavelResponseDTO responsavelParaResponsavelResponse(Responsavel responsavel) {
       return new ResponsavelResponseDTO(responsavel.getNome(),responsavel.getId());
    }
    
}
