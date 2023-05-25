package br.com.digix.terraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.terraria.dominio.Familia;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long>{
    
}
