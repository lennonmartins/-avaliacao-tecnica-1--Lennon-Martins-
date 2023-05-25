package br.com.digix.terraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.exceptions.DataDeNascimentoInvalid;
import br.com.digix.terraria.dominio.exceptions.DataNascimentoDependenteInvalid;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.dtos.responses.DependenteResponseDTO;
import br.com.digix.terraria.mappers.DependenteMapper;
import br.com.digix.terraria.repository.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    private DependenteMapper dependenteMapper;

    @Autowired
    private DependenteRepository dependenteRepository;


    public DependenteResponseDTO cadastrarDependente (DependenteRequestDTO dependenteRequestDTO) throws NomeInvalidException, DataDeNascimentoInvalid, DataNascimentoDependenteInvalid {
        Dependente dependente = dependenteMapper.dependenteRequestParaDepende(dependenteRequestDTO);
        dependenteRepository.save(dependente);
        return dependenteMapper.dependenteParaDependenteResponse(dependente);
    }
}
