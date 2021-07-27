package org.shenghuawu.superbuy.items;

import org.shenghuawu.superbuy.items.requests.CreateItemRequest;
import org.shenghuawu.superbuy.items.requests.UpdateItemRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemsService {
    private final Map<String, Item> items = new HashMap<>();

    public List<Item> getAllItems() {
        return items.values().stream().filter(item -> !item.getIsDeleted()).collect(Collectors.toList());
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
        Item existingItem = items.get(id);

        // TODO: Should throw an item-not-found exception?
        if (existingItem == null) {
            return null;
        }

        existingItem.markAsDeleted();
        items.put(id, existingItem);

        return existingItem;
    }
}
