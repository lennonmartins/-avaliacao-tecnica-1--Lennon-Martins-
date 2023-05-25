package br.com.digix.terraria.service;

import java.util.List;

import br.com.digix.terraria.dominio.Familia;

public interface ICriterios {
    public void validarSeAtendeCriterios(List<Familia> familia);
}
