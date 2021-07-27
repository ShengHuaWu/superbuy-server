package org.shenghuawu.superbuy.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.shenghuawu.superbuy.items.requests.CreateItemRequest;
import org.shenghuawu.superbuy.items.requests.UpdateItemRequest;

import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private Boolean isDeleted = false;

    // Use `@JsonProperty` to do proper JSON parsing
    public Item(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name
    ) {
        this.id = id;
        this.name = name;
    }

    public Item(String id, CreateItemRequest request) {
        this.id = id;
        this.name = request.getName();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(isDeleted, item.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isDeleted);
    }

    public void update(UpdateItemRequest request) {
        name = request.getName();
    }

    public void markAsDeleted() {
        isDeleted = true;
    }
}
