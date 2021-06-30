package org.shenghuawu.superbuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shenghuawu.superbuy.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SuperbuyApplicationTests {
	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@BeforeEach
	void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void getItems() throws Exception {
		String uri = "/items";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		ObjectReader objectReader = new ObjectMapper().readerFor(Map.class); // Use reader to suppress `Unchecked assignment` warning
		String contentString = mvcResult.getResponse().getContentAsString();
		Map<String, List<Item>> responseBody = objectReader.readValue(contentString);
		assertEquals(responseBody.get("items").size(), 1);
	}
}
