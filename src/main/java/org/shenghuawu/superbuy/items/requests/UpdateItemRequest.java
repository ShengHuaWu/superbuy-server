package org.shenghuawu.superbuy.items.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UpdateItemRequest {
    private String name;

    public UpdateItemRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateItemRequest that = (UpdateItemRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
