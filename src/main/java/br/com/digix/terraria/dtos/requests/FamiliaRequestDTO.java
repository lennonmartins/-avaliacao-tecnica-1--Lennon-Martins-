package br.com.digix.terraria.dtos.requests;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaRequestDTO {
    private long idDoConjuge;
    private long idDoResponsavel;
    private Collection<Long> dependentesIds;
    private double renda;
}
