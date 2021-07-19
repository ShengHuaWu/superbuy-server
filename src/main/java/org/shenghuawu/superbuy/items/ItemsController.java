package org.shenghuawu.superbuy.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
// Mark the class as `public` is necessary because it will be used outside of its package.
public class ItemsController {
    private final ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping("/items")
    public ResponseEntity<ItemResponseBody> createItem(@RequestBody Item item) {
        // TODO: Move the creation into `ItemsService`
        String id = UUID.randomUUID().toString();
        Item newItem = new Item(id, item.getName());
        itemsService.createItem(newItem);
        ItemResponseBody body = new ItemResponseBody(newItem);

        return new ResponseEntity(body, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    // Use `ResponseEntity` to handle the response body, headers, and status code.
    public ResponseEntity<ItemsResponseBody> getItems() {
        List<Item> items = itemsService.getAllItems();
        ItemsResponseBody body = new ItemsResponseBody(items);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemResponseBody> getItemBy(@PathVariable("itemId") String id) {
        Item item = itemsService.getItemById(id);
        ItemResponseBody body = new ItemResponseBody(item);

        return ResponseEntity.ok(body);
    }

    @PutMapping("/items/{itemId}")
    public  ResponseEntity<ItemResponseBody> updateItemBy(@PathVariable("itemId") String id, @RequestBody Item item) {
        Item newItem = itemsService.updateItemById(id, item);
        ItemResponseBody body = new ItemResponseBody(newItem);

        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<ItemResponseBody> deleteItemBy(@PathVariable("itemId") String id) {
        Item item = itemsService.deleteItemById(id);
        ItemResponseBody body = new ItemResponseBody(item);

        return new ResponseEntity(body, HttpStatus.NO_CONTENT);
    }
}
