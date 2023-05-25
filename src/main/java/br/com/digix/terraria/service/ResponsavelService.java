package br.com.digix.terraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ResponsavelRequestDTO;
import br.com.digix.terraria.dtos.responses.ResponsavelResponseDTO;
import br.com.digix.terraria.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public ResponsavelResponseDTO cadastrarResponsavel(ResponsavelRequestDTO novoResponsavel) throws NomeInvalidException {
       Responsavel responsavel = new Responsavel(novoResponsavel.getNomeDoResponsavel());
       responsavelRepository.save(responsavel);
       return new ResponsavelResponseDTO(responsavel.getNome(), responsavel.getId());
    }
}
