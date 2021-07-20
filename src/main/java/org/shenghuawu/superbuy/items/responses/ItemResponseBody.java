package org.shenghuawu.superbuy.items.responses;

import org.shenghuawu.superbuy.items.Item;

public class ItemResponseBody {
    private Item item;

    public ItemResponseBody(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
