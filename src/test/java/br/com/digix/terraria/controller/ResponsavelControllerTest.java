package br.com.digix.terraria.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dtos.requests.ResponsavelRequestDTO;
import br.com.digix.terraria.repository.ResponsavelRepository;
import br.com.digix.terraria.utils.JsonUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class ResponsavelControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @BeforeEach
	@AfterEach
	public void deleteDados() {
		responsavelRepository.deleteAll();
	};

    @Test
	public void deve_incluir_um_responsavel() throws Exception  {
		int quantitadeEsperado = 1;
		
        ResponsavelRequestDTO responsavelRequestDTO = new ResponsavelRequestDTO("Lennon");

		mockMvc.perform(post("/api/v1/responsaveis")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(responsavelRequestDTO)))
				.andExpect(status().isCreated());

		List<Responsavel> responsavelRetornados = responsavelRepository.findByNomeContainingIgnoreCase(responsavelRequestDTO.getNomeDoResponsavel());
		assertThat(responsavelRetornados.size()).isEqualTo(quantitadeEsperado);
		assertThat(responsavelRetornados.stream().map(Responsavel::getNome).toList()).contains(responsavelRequestDTO.getNomeDoResponsavel());
	}
}
