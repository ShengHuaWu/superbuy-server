package org.shenghuawu.superbuy.items.responses;

import org.shenghuawu.superbuy.items.Item;

import java.util.List;

public class ItemsResponseBody {
    // TODO: Avoid return the entire item, e.g. excluding `isDeleted`
    private List<Item> items;

    public ItemsResponseBody(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return this.items;
    }
}
