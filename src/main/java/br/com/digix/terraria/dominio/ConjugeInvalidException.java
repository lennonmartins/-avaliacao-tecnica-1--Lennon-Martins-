package br.com.digix.terraria.dominio;

public class ConjugeInvalidException extends Exception{
    public ConjugeInvalidException(){
        super("O cônjuge do Responsável não deve ser nulo.");
    }
}
