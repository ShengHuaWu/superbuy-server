package org.shenghuawu.superbuy.items;

import org.shenghuawu.superbuy.items.requests.CreateItemRequest;
import org.shenghuawu.superbuy.items.requests.UpdateItemRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemsService {
    private final Map<String, Item> items = new HashMap<>();

    public List<Item> getAllItems() {
        return new ArrayList(items.values());
    }

    public Item getItemById(String id) {
        Item item = items.get(id);

        if (item == null) {
            throw new RuntimeException("Item not found");
        }

        return item;
    }

    public Item createItem(CreateItemRequest request) {
        String id = UUID.randomUUID().toString();
        Item newItem = new Item(id, request);
        items.put(newItem.getId(), newItem);

        return newItem;
    }

    public Item updateItemById(String id, UpdateItemRequest request) {
        Item existingItem = items.get(id);

        if (existingItem == null) {
            throw new RuntimeException("Item not found");
        }

        existingItem.update(request);
        items.put(id, existingItem);

        return existingItem;
    }

    public Item deleteItemById(String id) {
        return items.remove(id);
    }
}
