package br.com.digix.terraria.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.dtos.responses.DependenteResponseDTO;

@Mapper(componentModel = "spring")
public interface DependenteMapper {
    Dependente dependenteRequestParaDepende(DependenteRequestDTO dependenteRequestDTO) throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid;
    DependenteResponseDTO dependenteParaDependenteResponse(Dependente dependente);
    Collection<DependenteResponseDTO> dependentesParaDependentesResponses(Collection<Dependente> dependentes);
}
