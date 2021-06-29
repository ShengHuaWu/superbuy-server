package org.shenghuawu.superbuy.items;

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
