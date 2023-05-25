package br.com.digix.terraria.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dto.FamiliaRequestDTO;
import br.com.digix.terraria.dto.FamiliaResponseDTO;
import br.com.digix.terraria.repository.ConjugeRepository;
import br.com.digix.terraria.repository.DependenteRepository;
import br.com.digix.terraria.repository.ResponsavelRepository;

public class FamiliaMapperImpl implements FamiliaMapper{
    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private ConjugeRepository conjugeRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Override
    public Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO) {
        Collection<Dependente> dependentes = new ArrayList<>();
        for (Long idDoDependente : familiaRequestDTO.getDependentesIds()) {
            Optional<Dependente> dependenteOptional = dependenteRepository.findById(idDoDependente);
            if (dependenteOptional.isEmpty()) {
                throw new NoSuchElementException();
            }
            Dependente dependente = dependenteOptional.get();
            dependentes.add(dependente);
        }

        Optional<Conjuge> conjugeOptional = conjugeRepository.findById(familiaRequestDTO.getIdDoConjuge());
        if (conjugeOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        Conjuge conjuge = conjugeOptional.get();

        Optional<Responsavel> responsavelOptional = responsavelRepository.findById(familiaRequestDTO.getIdDoResponsavel());
        if (responsavelOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        Responsavel responsavel = responsavelOptional.get();

        return new Familia(conjuge,
         responsavel,  (List<Dependente>) dependentes, null, 0)
    }

    @Override
    public FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'familiaParaFamiliaResponse'");
    }
    
}
