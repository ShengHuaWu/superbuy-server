package org.shenghuawu.superbuy.items.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CreateItemRequest {
    private String name;

    public CreateItemRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateItemRequest request = (CreateItemRequest) o;
        return Objects.equals(name, request.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
