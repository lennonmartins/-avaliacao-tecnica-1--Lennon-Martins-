package br.com.digix.terraria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListagemResponseDTO {
    private String nomeDoResponsavel;
    private int pontuacao;
}
