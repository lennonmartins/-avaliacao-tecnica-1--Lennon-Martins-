package br.com.digix.terraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dto.FamiliaRequestDTO;
import br.com.digix.terraria.dto.FamiliaResponseDTO;
import br.com.digix.terraria.mappers.FamiliaMapper;
import br.com.digix.terraria.repository.FamiliaRepository;

@Service
public class FamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaMapper familiaMapper;
    
    public FamiliaResponseDTO cadastraFamilia (FamiliaRequestDTO familiaRequestDTO){
        Familia familia = familiaMapper.familiaRequestParaFamilia(familiaRequestDTO);
        familiaRepository.save(familia);
        return familiaMapper.familiaParaFamiliaResponse(familia);
    }
}
