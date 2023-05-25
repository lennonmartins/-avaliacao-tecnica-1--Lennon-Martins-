package br.com.digix.terraria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.terraria.dominio.Dependente;

@Repository
public interface DependenteRepository extends CrudRepository <Dependente, Long>{

    List<Dependente> findByNomeContainingIgnoreCase(String nomeDoDependente);
    
}
