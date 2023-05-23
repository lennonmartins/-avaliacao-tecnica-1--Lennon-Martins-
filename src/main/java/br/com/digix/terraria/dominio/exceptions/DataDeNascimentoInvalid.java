package br.com.digix.terraria.dominio.exceptions;

public class DataDeNascimentoInvalid extends Exception{
    public DataDeNascimentoInvalid(){
        super("A idade do dependente deve estar preenchida.");
    }
}
