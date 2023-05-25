package br.com.digix.terraria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Renda{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double rendaMensal;

    @OneToOne
    @JoinColumn(name="familia_id")
    private Familia familia;
    
    public Renda(double rendaMensal){
        this.rendaMensal = rendaMensal;
    }

    public long getId() {
        return this.id;
    }
}
