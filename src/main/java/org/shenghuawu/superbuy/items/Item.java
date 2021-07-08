package org.shenghuawu.superbuy.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private String id;
    private String name;

    public Item(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
