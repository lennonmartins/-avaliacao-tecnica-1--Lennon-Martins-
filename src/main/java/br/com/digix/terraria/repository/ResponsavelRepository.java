package br.com.digix.terraria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.terraria.dominio.Responsavel;

@Repository
public interface ResponsavelRepository extends CrudRepository <Responsavel, Long> {

    List<Responsavel> findByNomeContainingIgnoreCase(String nomeDoResponsavel);
}
