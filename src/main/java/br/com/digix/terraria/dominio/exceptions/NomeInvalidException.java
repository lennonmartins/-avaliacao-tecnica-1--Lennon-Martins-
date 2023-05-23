package br.com.digix.terraria.dominio.exceptions;

public class NomeInvalidException extends Exception {
    public NomeInvalidException(){
        super("A pessoa não deve ter nome vazio ou nulo.");
    }
}