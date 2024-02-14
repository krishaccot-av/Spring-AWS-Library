package com.krish.booklibrary.model;

import java.util.List;

public class SearchResult {
    public List<BookItem> getItems() {
        return items;
    }

    public void setItems(List<BookItem> items) {
        this.items = items;
    }

    public List<BookItem> items;
}
