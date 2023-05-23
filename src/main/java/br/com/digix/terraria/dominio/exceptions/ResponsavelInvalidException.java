package br.com.digix.terraria.dominio.exceptions;

public class ResponsavelInvalidException extends Exception{
    public ResponsavelInvalidException(){
        super("O Responsável pela família não deve ser nulo.");
    }
}
