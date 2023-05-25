package br.com.digix.terraria.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import br.com.digix.terraria.dtos.requests.FamiliaRequestDTO;
import br.com.digix.terraria.dtos.responses.FamiliaResponseDTO;
import br.com.digix.terraria.repository.ConjugeRepository;
import br.com.digix.terraria.repository.DependenteRepository;
import br.com.digix.terraria.repository.ResponsavelRepository;

@Component
public class FamiliaMapperImpl implements FamiliaMapper {
    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private ConjugeRepository conjugeRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ConjugeMapper conjugeMapper;

    @Autowired
    private ResponsavelMapper responsavelMapper;

    @Autowired
    private DependenteMapper dependenteMapper;

    @Override
    public Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO)
            throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
        Collection<Dependente> dependentes = new ArrayList<>();

        int valorInvalido = 0;
        boolean possuiDependente = familiaRequestDTO.getDependentesIds() != null
                && !familiaRequestDTO.getDependentesIds().isEmpty()
                && familiaRequestDTO.getDependentesIds().contains(valorInvalido);

        if (possuiDependente) {

            for (Long idDoDependente : familiaRequestDTO.getDependentesIds()) {
                Optional<Dependente> dependenteOptional = dependenteRepository.findById(idDoDependente);
                if (dependenteOptional.isEmpty()) {
                    throw new NoSuchElementException();
                }
                Dependente dependente = dependenteOptional.get();
                dependentes.add(dependente);
            }
        }
       
        Optional<Conjuge> conjugeOptional = conjugeRepository.findById(familiaRequestDTO.getIdDoConjuge());
        if (conjugeOptional.isEmpty()) {
           throw new ConjugeInvalidException();
        }
        Conjuge conjuge = conjugeOptional.get();

        Optional<Responsavel> responsavelOptional = responsavelRepository
                .findById(familiaRequestDTO.getIdDoResponsavel());
        if (responsavelOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        Responsavel responsavel = responsavelOptional.get();

        return new Familia(conjuge,
                responsavel,
                (List<Dependente>) dependentes,
                familiaRequestDTO.getRenda(), 0);
    }

    @Override
    public FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia) {
        return new FamiliaResponseDTO(
                familia.getId(),
                conjugeMapper.conjugeParaConjugeResponse(familia.getConjuge()),
                responsavelMapper.responsavelParaResponsavelResponse(familia.getResponsavel()),
                dependenteMapper.dependentesParaDependentesResponses(familia.getDependentes()),
                familia.getRendaMensal());
    }
}
