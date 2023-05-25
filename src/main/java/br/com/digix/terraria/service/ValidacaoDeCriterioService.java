package br.com.digix.terraria.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.repository.FamiliaRepository;

@Service
public class ValidacaoDeCriterioService {

    @Autowired
    private ICriterios criteriosMapper;

    @Autowired
    private FamiliaRepository familiaRepository;
    
    public List<Familia> pontuarFamiliaPelosCriteriosAtendidos(){
        List<Familia> familias = (List<Familia>) buscarTodas();
        validarOsCriteriosAtendidos(familias);
        return familias;
    }

    public void validarOsCriteriosAtendidos(List<Familia> familias){
        this.criteriosMapper.validarSeAtendeCriterios(familias);
    }

    private Collection<Familia> buscarTodas() {
        return ((Collection<Familia>) familiaRepository.findAll());
    }  
}
