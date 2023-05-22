package br.com.digix.terraria.dominio;

public class RendaInvalidaException extends Exception{
    public RendaInvalidaException(){
        super("A renda da família deve estar entre 0 e 1500 para participar.");
    }
}
