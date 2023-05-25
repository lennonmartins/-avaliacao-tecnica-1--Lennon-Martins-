package br.com.digix.terraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dtos.requests.ConjugeRequestDTO;
import br.com.digix.terraria.dtos.responses.ConjugeResponseDTO;
import br.com.digix.terraria.repository.ConjugeRepository;

@Service
public class ConjugeService {

    @Autowired
    private ConjugeRepository conjugeRepository;

    public ConjugeResponseDTO cadastrarConjuge(ConjugeRequestDTO novoConjuge) throws NomeInvalidException {
        Conjuge conjuge = new Conjuge(novoConjuge.getNomeDoConjuge());
        conjugeRepository.save(conjuge);
        return new ConjugeResponseDTO(conjuge.getNome(), conjuge.getId());
    }
}
