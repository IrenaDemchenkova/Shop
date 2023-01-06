package ru.irendemchenkova.shop;

import ru.irendemchenkova.shop.order.Order;

import java.util.ArrayList;
import java.util.List;

public class User implements Identifiable {
    private final String username;
    private final String firstname;
    private final String lastname;
    private final List<Order> orders = new ArrayList<>();

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void registerOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public String getId() {
        return this.getUsername();
    }
}
