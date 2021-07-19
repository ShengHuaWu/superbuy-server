package org.shenghuawu.superbuy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shenghuawu.superbuy.items.Item;
import org.shenghuawu.superbuy.items.ItemsController;
import org.shenghuawu.superbuy.items.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@WebMvcTest(ItemsController.class) // TODO: Figure out `WebMvcTest`
class SuperbuyApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ItemsService mockItemsService;

	/*
	@Test
	void createItem() throws Exception {
		String itemName = "Fake Item";
		String body = String.format("{\"name\": \"%s\"}", itemName);
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders
						.post("/items")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(body)
						.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(201, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, Item> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, Item>>() {});

		assertEquals(responseBody.get("item").getName(), itemName);
	}*/

	@Test
	void getItems() throws Exception {
		Item fakeItem = new Item("1234-9876-abcd-7788", "Fake Item");
		Mockito.when(mockItemsService.getAllItems()).thenReturn(Arrays.asList(fakeItem));

		MvcResult result = mvc.perform(
				MockMvcRequestBuilders
						.get("/items")
						.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		// Use `TypeReference` to match the exact type when parsing JSON
		Map<String, List<Item>> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, List<Item>>>() {});

		assertEquals(responseBody.get("items").size(), 1);
		assertEquals(responseBody.get("items").get(0), fakeItem);
	}

	/*
	@Test
	void getItemById() throws Exception {
		Item fakeItem = new Item("1234-9876-abcd-7788", "Fake Item");

		String urlString = String.format("/items/%s", fakeItem.getId());
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders
						.get(urlString)
						.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, Item> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, Item>>() {});

		assertEquals(responseBody.get("item"), fakeItem);
	}

	@Test
	void updateItemById() throws Exception {
		Item expectedItem = new Item("1234-9876-abcd-7788", "Fake Item");

		String urlString = String.format("/items/%s", expectedItem.getId());
		String body = String.format("{\"name\": \"%s\"}", expectedItem.getName());
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders
						.put(urlString)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(body)
						.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, Item> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, Item>>() {});

		assertEquals(responseBody.get("item"), expectedItem);
	}

	@Test
	void deleteItemById() throws Exception {
		Item fakeItem = new Item("1234-9876-abcd-7788", "Fake Item");

		String urlString = String.format("/items/%s", fakeItem.getId());
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders
						.delete(urlString)
						.accept(MediaType.APPLICATION_JSON_VALUE)
		).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(204, status);

		ObjectMapper mapper = new ObjectMapper();
		String contentString = result.getResponse().getContentAsString();
		Map<String, Item> responseBody = mapper.readValue(contentString, new TypeReference<Map<String, Item>>() {});

		assertEquals(responseBody.get("item"), fakeItem);
	}*/
}
