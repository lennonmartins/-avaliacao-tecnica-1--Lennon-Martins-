package br.com.digix.terraria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConjugeResponseDTO {
    private String nome;
    private Long idConjuge;
}
