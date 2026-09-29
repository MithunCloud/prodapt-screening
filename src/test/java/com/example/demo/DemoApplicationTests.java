package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testBasic() throws Exception{
		mockMvc.perform(get("/remove").param("str", "eloquent"))
				.andExpect(status().isOk())
				.andExpect(content().string("loquen"));
		mockMvc.perform(get("/remove").param("str", "country"))
				.andExpect(status().isOk())
				.andExpect(content().string("ountr"));

	}

	@Test
	void testEdgeCases() throws Exception{
		mockMvc.perform(get("/remove").param("str", "ab"))
				.andExpect(status().isOk())
				.andExpect(content().string(""));

		mockMvc.perform(get("/remove").param("str", "a"))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testSpecialCharactersAndNumbers() throws Exception{
		mockMvc.perform(get("/remove").param("str", "123%qwerty+"))
				.andExpect(status().isOk())
				.andExpect(content().string("23%qwerty"));
	}

}
