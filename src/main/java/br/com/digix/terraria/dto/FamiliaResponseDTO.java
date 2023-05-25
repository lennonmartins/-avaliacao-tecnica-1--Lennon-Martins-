package br.com.digix.terraria.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaResponseDTO {
    private Long id;
    private Long idDoConjuge;
    private Long idDoResponsavel;
    private Collection<Long> dependentesIds;
    private Long renda;
}

