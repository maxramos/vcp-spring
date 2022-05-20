package ph.mramos.vcps.section07.rest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ph.mramos.vcps.section04.springdatajpa.SampleSpringDataJpaConfig;
import ph.mramos.vcps.section05.webmvc.SampleWebMvcConfig;

@SpringJUnitWebConfig(classes = { SampleSpringDataJpaConfig.class, SampleWebMvcConfig.class })
public class PersonApiControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.alwaysDo(MockMvcResultHandlers.print())
				.build();
	}

	@Test
	public void testFind() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/person/{id}", 1).accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("max"));
	}

}
