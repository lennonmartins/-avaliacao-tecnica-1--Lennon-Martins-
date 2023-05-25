package br.com.digix.terraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.terraria.dominio.Responsavel;

@Repository
public interface ResponsavelRepository extends CrudRepository <Responsavel, Long> {
    
}
