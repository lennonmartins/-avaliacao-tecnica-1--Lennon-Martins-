package br.com.digix.terraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.terraria.dominio.Conjuge;

@Repository
public interface ConjugeRepository extends CrudRepository<Conjuge, Long>{
    
}
