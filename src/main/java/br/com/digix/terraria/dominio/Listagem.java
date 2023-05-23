package br.com.digix.terraria.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.digix.terraria.dominio.utils.Comparador;

public class Listagem {
    private List<Familia> familias;

    public Listagem() {
        this.familias = new ArrayList<>();
    }

    public void adicionarFamilia(Familia familia) {
        this.familias.add(familia);
    }

    public List<Familia> listarFamilias(){
        return this.familias;
    }

    public void ordernarFamiliasPelaPontuacao() {
         Collections.sort(this.familias,Comparador.comparador());
    }

}
