package ru.irendemchenkova.shop.catalogue;

import ru.irendemchenkova.shop.Identifiable;

import java.util.HashMap;

public interface Catalogue<T extends Identifiable> {
    void addToStorage(T item);

    void removeFromStorage(T item);

    HashMap<String, T> getStorage();
}
