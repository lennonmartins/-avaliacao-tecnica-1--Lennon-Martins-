package br.com.digix.terraria.mappers;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dto.FamiliaRequestDTO;
import br.com.digix.terraria.dto.FamiliaResponseDTO;

public interface FamiliaMapper {
    Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO);
    FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia);
}
