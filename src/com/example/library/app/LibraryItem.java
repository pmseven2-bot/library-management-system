
package com.example.library.app;

public abstract class LibraryItem implements Identifiable<String> {

    private final String id; //This is immutable because: it's final
    private final String title;

    protected LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getItemType();
}
