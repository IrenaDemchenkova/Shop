package ru.irendemchenkova.shop;

import ru.irendemchenkova.shop.items.Item;

import java.util.HashMap;

public class Cart {
    private final User user;
    private final HashMap<String, CartItem> items = new HashMap<>();

    public Cart(User user) {
        this.user = user;
    }

    public void addItem(Item item) {
        this.addItem(item, 1);
    }

    public void addItem(Item item, int quantity) {
        if (this.items.containsKey(item.getId())) {
            CartItem cartItem = this.items.get(item.getId());
            this.items.replace(item.getId(), new CartItem(item, cartItem.getQuantity() + quantity));
            return;
        }

        this.items.put(item.getId(), new CartItem(item, quantity));
        item.decreaseQuantity(quantity);
    }

    public void removeItem(Item item) {
        this.items.remove(item.getId());
    }

    public User getUser() {
        return user;
    }

    public HashMap<String, CartItem> getItems() {
        return items;
    }

    public double calculateTotalCartPrice() {
        double totalCartPrice = 0.0;
        for (CartItem item : this.items.values())
            totalCartPrice += item.calculateTotalPrice();
        return totalCartPrice;
    }

    public void clearCart() {
        this.items.clear();
    }
}
