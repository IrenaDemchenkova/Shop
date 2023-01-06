package ru.irendemchenkova.shop.catalogue;

import ru.irendemchenkova.shop.items.Item;

import java.util.HashMap;

public class ItemsCatalogue implements Catalogue<Item> {
    private static ItemsCatalogue instance;
    private final HashMap<String, Item> storage = new HashMap<>();

    private ItemsCatalogue() {}

    public static ItemsCatalogue getInstance() {
        if (instance == null)
            instance = new ItemsCatalogue();
        return instance;
    }

    @Override
    public void addToStorage(Item item) {
        this.storage.put(item.getId(), item);
    }

    @Override
    public void removeFromStorage(Item item) {
        this.storage.remove(item.getId());
    }

    @Override
    public HashMap<String, Item> getStorage() {
        return this.storage;
    }
}
