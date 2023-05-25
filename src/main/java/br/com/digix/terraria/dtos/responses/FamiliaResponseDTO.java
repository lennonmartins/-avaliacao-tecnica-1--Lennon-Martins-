package br.com.digix.terraria.dtos.responses;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaResponseDTO {
    private long id;
    private ConjugeResponseDTO conjuge;
    private ResponsavelResponseDTO Responsavel;
    private Collection<DependenteResponseDTO> dependentes;
    private double renda;
}

