package br.com.digix.terraria.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Conjuge extends Pessoa {

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="familia_id")
    private Familia familia;
    
    public Conjuge(String nome) throws NomeInvalidException {
        super(nome);
    }   
}
