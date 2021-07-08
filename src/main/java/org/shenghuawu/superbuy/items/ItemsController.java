package org.shenghuawu.superbuy.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
// Mark the class as `public` is necessary because it will be used outside of its package.
public class ItemsController {
    @Autowired
    public ItemsController() {}

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
        Item item = new Item("1234-9876-abcd-7788", "Fake Item");
        ItemResponseBody body = new ItemResponseBody(item);

        return ResponseEntity.ok(body);
    }
}
