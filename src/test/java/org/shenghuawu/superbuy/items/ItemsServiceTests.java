package org.shenghuawu.superbuy.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shenghuawu.superbuy.items.requests.CreateItemRequest;
import org.shenghuawu.superbuy.items.requests.UpdateItemRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ItemsServiceTests {
    private ItemsService itemsService;

    @BeforeEach
    void setUp() {
        itemsService = new ItemsService();
    }

    @Test
    void operations() throws Exception {
        // Create
        String name = "Blob";
        CreateItemRequest createItemRequest = new CreateItemRequest(name);
        Item newItem = itemsService.createItem(createItemRequest);

        assertNotNull(newItem);
        assertNotNull(newItem.getId());
        assertEquals(name, newItem.getName());

        // Get all & get one
        List<Item> items = itemsService.getAllItems();
        assertEquals(1, items.size());
        assertEquals(newItem, items.get(0));

        Item item = itemsService.getItemById(newItem.getId());
        assertEquals(newItem, item);

        // Update
        String newName = "Blob Jr";
        UpdateItemRequest updateItemRequest = new UpdateItemRequest(newName);
        Item updatedItem = itemsService.updateItemById(newItem.getId(), updateItemRequest);
        assertEquals(newItem.getId(), updatedItem.getId());
        assertEquals(newName, updatedItem.getName());

        // Delete
        Item deletedItem = itemsService.deleteItemById(updatedItem.getId());
        items = itemsService.getAllItems();
        assertEquals(updatedItem, deletedItem);
        assertTrue(items.isEmpty());
    }

    @Test
    void getItemByItemNotFound() throws Exception {
        try {
            Item item = itemsService.getItemById("not-found");
            fail("Item not found should be caught");
        } catch (RuntimeException exception) {
            assertEquals("Item not found", exception.getMessage());
        }
    }

    @Test
    void updateItemByItemNotFound() throws Exception {
        try {
            UpdateItemRequest request = new UpdateItemRequest("new name");
            Item item = itemsService.updateItemById("not-found", request);
            fail("Item not found should be caught");
        } catch (RuntimeException exception) {
            assertEquals("Item not found", exception.getMessage());
        }
    }
}