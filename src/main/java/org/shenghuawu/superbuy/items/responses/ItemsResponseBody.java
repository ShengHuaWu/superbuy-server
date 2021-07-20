package org.shenghuawu.superbuy.items.responses;

import org.shenghuawu.superbuy.items.Item;

import java.util.List;

public class ItemsResponseBody {
    private List<Item> items;

    public ItemsResponseBody(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return this.items;
    }
}
