package br.com.digix.terraria.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dtos.requests.DependenteRequestDTO;
import br.com.digix.terraria.repository.DependenteRepository;
import br.com.digix.terraria.utils.JsonUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class DependenteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DependenteRepository dependenteRepository;

    @BeforeEach
	@AfterEach
	public void deleteDados() {
		dependenteRepository.deleteAll();
	};

    @Test
	public void deve_incluir_um_dependente() throws Exception  {
		int quantitadeEsperado = 1;
		
		DependenteRequestDTO dependenteRequestDTO = new DependenteRequestDTO("Esther", "2010-07-19");

		mockMvc.perform(post("/api/v1/dependentes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(dependenteRequestDTO)))
				.andExpect(status().isCreated());

		List<Dependente> dependentesRetornados = dependenteRepository.findByNomeContainingIgnoreCase(dependenteRequestDTO.getNomeDoDependente());
		Assertions.assertThat(dependentesRetornados.size()).isEqualTo(quantitadeEsperado);
		Assertions.assertThat(dependentesRetornados.stream().map(Dependente::getNome).toList()).contains(dependenteRequestDTO.getNomeDoDependente());

	}

}
