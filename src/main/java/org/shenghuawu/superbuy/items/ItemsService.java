package org.shenghuawu.superbuy.items;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Item createItem(Item newItem) {
        // TODO: Need a `CreateItemRequestBody` for creation
        items.put(newItem.getId(), newItem);

        return newItem;
    }

    // TODO: Need a `UpdateItemRequestBody` to support partial update
    public Item updateItemById(String id, Item newItem) {
        items.put(id, newItem);

        return newItem;
    }

    public Item deleteItemById(String id) {
        return items.remove(id);
    }
}
