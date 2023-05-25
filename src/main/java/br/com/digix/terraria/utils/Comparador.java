package br.com.digix.terraria.utils;

import java.util.Comparator;

import br.com.digix.terraria.dominio.Familia;

public class Comparador {
    public static Comparator<Familia>  comparador(){
    Comparator<Familia> compararPontos = new Comparator<Familia>() {

        @Override
        public int compare(Familia familiaASercomparada, Familia familiaComparada) {
                int pontuacaoASercomparada = familiaASercomparada.getPontuacao();
                int potuacaoComparada = familiaComparada.getPontuacao();
                
                if(pontuacaoASercomparada < potuacaoComparada){
                    return 1;
                }else if(pontuacaoASercomparada> potuacaoComparada){
                    return -1;
                }else{
                    return 0;
                }
        }
    };
    return compararPontos;
}
}
