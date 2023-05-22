package br.com.digix.terraria.dominio;

public class DependentesInvalidException extends Exception{
    public DependentesInvalidException(){
        super("Uma Família deve ter pelo menos um dependente.");
    }
}
