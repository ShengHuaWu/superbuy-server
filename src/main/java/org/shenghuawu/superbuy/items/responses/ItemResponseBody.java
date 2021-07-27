package org.shenghuawu.superbuy.items.responses;

import org.shenghuawu.superbuy.items.Item;

public class ItemResponseBody {
    // TODO: Avoid return the entire item, e.g. excluding `isDeleted`
    private Item item;

    public ItemResponseBody(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
