package ru.irendemchenkova.shop;

import ru.irendemchenkova.shop.catalogue.ItemsCatalogue;
import ru.irendemchenkova.shop.items.ItemSize;
import ru.irendemchenkova.shop.items.types.FoodItem;
import ru.irendemchenkova.shop.items.types.NonFoodItem;
import ru.irendemchenkova.shop.order.Address;
import ru.irendemchenkova.shop.order.Order;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user = new User("hello", "Ivan", "Ivanov");
        ItemsCatalogue itemsCatalogue = ItemsCatalogue.getInstance();

        FoodItem apple = new FoodItem.Builder()
                .setId("apple")
                .setDescription("apple")
                .setPrice(10.99)
                .setProductionDate(2023, 1, 4)
                .setShelfLife(30)
                .setStartQuantity(30)
                .build();

        NonFoodItem monitor = new NonFoodItem.Builder()
                .setId("monitor")
                .setDescription("monitor")
                .setPrice(199.99)
                .setStartQuantity(100)
                .setSize(new ItemSize.Builder()
                        .setWidth(50.37)
                        .setHeight(15.10)
                        .setLength(7.3)
                        .setWeight(15)
                        .setIsFragile(true)
                        .build())
                .build();

        itemsCatalogue.addToStorage(apple);
        itemsCatalogue.addToStorage(monitor);

        System.out.println("Available items:");
        itemsCatalogue.getStorage().forEach((id, item) ->
                System.out.printf("ID: %5s\tDescription: %5s\t%5d available\t%5.2f rubles\n", id, item.getDescription(), item.getQuantity(), item.getPrice()));

        Cart cart = new Cart(user);
        cart.addItem(apple, 20);
        cart.addItem(monitor);

        // потом это можно убрать
        System.out.println("\n\n");

        System.out.println("In your cart:");
        cart.getItems().forEach((id, item) ->
            System.out.printf("ID: %5s\tItem quantity:%5d\tTotal item price: %5.2f rubles\n", id, item.getQuantity(), item.calculateTotalPrice()));
        System.out.printf("Total cart price: %.2f rubles\n", cart.calculateTotalCartPrice());

        Address address = new Address.Builder()
                .setCountry("Russia")
                .setCity("Moscow")
                .setStreet("Kievskaya")
                .setBuildingNo(5)
                .build();

        Order order = new Order.Builder()
                .fromCart(cart)
                .setDeliveryAddress(address)
                .build();

        System.out.printf("Order status: %s\n", order.getStatus());
        Thread.sleep(1000);
        order.paid();
        System.out.printf("Order status: %s\n", order.getStatus());
        Thread.sleep(1000);
        order.packed();
        System.out.printf("Order status: %s\n", order.getStatus());
        Thread.sleep(1000);
        order.delivery();
        System.out.printf("Order status: %s\n", order.getStatus());
        Thread.sleep(1000);
        order.completed();
        System.out.printf("Order status: %s\n", order.getStatus());
    }
}
