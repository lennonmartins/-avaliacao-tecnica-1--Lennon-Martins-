package br.com.digix.terraria.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenteRequestDTO {
    private String nomeDoDependente;
    private String dataDeNascimento;
}
