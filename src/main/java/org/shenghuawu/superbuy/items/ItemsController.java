package org.shenghuawu.superbuy.items;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
// Mark the class as `public` is necessary because it will be used outside of its package.
public class ItemsController {
    @Autowired
    public ItemsController() {}

    @PostMapping("/items")
    public ResponseEntity<ItemResponseBody> createItem(@RequestBody Item item) {
        Item newItem = new Item("1234-9876-abcd-7788", item.getName());
        ItemResponseBody body = new ItemResponseBody(newItem);

        return new ResponseEntity(body, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    // Use `ResponseEntity` to handle the response body, headers, and status code.
    public ResponseEntity<ItemsResponseBody> getItems() {
        Item item = new Item("1234-9876-abcd-7788", "Fake Item");
        List<Item> items = Arrays.asList(item);
        ItemsResponseBody body = new ItemsResponseBody(items);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemResponseBody> getItemBy(@PathVariable("itemId") String id) {
        Item item = new Item(id, "Fake Item");
        ItemResponseBody body = new ItemResponseBody(item);

        return ResponseEntity.ok(body);
    }

    @PutMapping("/items/{itemId}")
    public  ResponseEntity<ItemResponseBody> updateItemBy(@PathVariable("itemId") String id, @RequestBody Item item) {
        Item newItem = new Item(id, item.getName());
        ItemResponseBody body = new ItemResponseBody(newItem);

        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<ItemResponseBody> deleteItemBy(@PathVariable("itemId") String id) {
        Item item = new Item("1234-9876-abcd-7788", "Fake Item");
        ItemResponseBody body = new ItemResponseBody(item);

        return new ResponseEntity(body, HttpStatus.NO_CONTENT);
    }
}
