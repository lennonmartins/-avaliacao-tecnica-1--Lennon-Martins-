package br.com.digix.terraria.mappers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.dtos.responses.DependenteResponseDTO;
import br.com.digix.terraria.utils.DataConvert;

@Component
public class DependenteMapperImpl implements DependenteMapper {

    @Override
    public Collection<DependenteResponseDTO> dependentesParaDependentesResponses(
            Collection<Dependente> dependentes) {
               Collection<DependenteResponseDTO> dependenteResponsesDtos = new ArrayList<>();
                for(Dependente dependente : dependentes){
                    dependenteResponsesDtos.add(this.dependenteParaDependenteResponse(dependente));
                }
                return dependenteResponsesDtos;
    }

    @Override
    public DependenteResponseDTO dependenteParaDependenteResponse(Dependente dependente) {
       return new DependenteResponseDTO(dependente.getNome(),dependente.getId());
    }

    @Override
    public Dependente dependenteRequestParaDepende(DependenteRequestDTO dependenteRequestDTO) throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid {
        return new Dependente(
            dependenteRequestDTO.getNomeDoDependente(),
            DataConvert.obterData(dependenteRequestDTO.getDataDeNascimento()));
    }
}
