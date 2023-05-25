package br.com.digix.terraria.dominio.exceptions;

public class DataNascimentoDependenteInvalid extends Exception {
    public DataNascimentoDependenteInvalid(){
        super("Não pode cadastrar um dependente com mais de 18 anos.");
    }
}
