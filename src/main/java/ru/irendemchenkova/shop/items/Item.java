package ru.irendemchenkova.shop.items;

import ru.irendemchenkova.shop.Identifiable;

public class Item implements Identifiable {
    private final String id;
    private final String description;
    private int quantity;
    private final double price;

    public Item(String id, String description, int startQuantity, double price) {
        this.id = id;
        this.description = description;
        this.quantity = startQuantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int amount) {
        quantity -= amount;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
