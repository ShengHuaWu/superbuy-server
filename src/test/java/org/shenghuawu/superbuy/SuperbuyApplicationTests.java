package org.shenghuawu.superbuy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, List<Item>> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, List<Item>>>() {});
		assertEquals(responseBody.get("items").size(), 1);
	}

	@Test
	void getItemById() throws Exception {
		Item fakeItem = new Item("1234-9876-abcd-7788", "Fake Item");

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/items/1234-9876-abcd-7788").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, Item> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, Item>>() {});

		assertEquals(responseBody.get("item").getId(), fakeItem.getId());
		assertEquals(responseBody.get("item").getName(), fakeItem.getName());
		// TODO: Implement isEqual in Item?
	}
}
