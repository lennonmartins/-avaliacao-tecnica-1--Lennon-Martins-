package br.com.digix.terraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.terraria.dominio.Dependente;

public interface DependenteRepository extends CrudRepository <Dependente, Long>{
    
}
