package ru.irendemchenkova.shop.order;

import ru.irendemchenkova.shop.Cart;
import ru.irendemchenkova.shop.CartItem;
import ru.irendemchenkova.shop.User;

import java.util.List;

public class Order {
    private OrderStatus status = OrderStatus.CREATED;
    private final List<CartItem> items;
    private final double totalPrice;
    private final User user;
    private final Address deliveryAddress;

    public Order(double totalPrice, User user, List<CartItem> items, Address deliveryAddress) {
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void paid() {
        this.user.registerOrder(this);
        this.setStatus(OrderStatus.PAID);
    }

    public void packed() {
        this.setStatus(OrderStatus.PACKED);
    }

    public void delivery() {
        this.setStatus(OrderStatus.IN_DELIVERY);
    }

    public void completed() {
        this.setStatus(OrderStatus.COMPLETED);
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", deliveryAddress=" + deliveryAddress +
                '}';
    }

    public static final class Builder {
        private User user;
        private Double totalPrice;
        private List<CartItem> items;
        private Address deliveryAddress;

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setItems(List<CartItem> items) {
            this.items = items;
            return this;
        }

        public Builder fromCart(Cart cart) {
            cart.clearCart();
            this.setUser(cart.getUser());
            this.setTotalPrice(cart.calculateTotalCartPrice());
            this.setItems(cart.getItems().values().stream().toList());
            return this;
        }

        public Builder setDeliveryAddress(Address deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Order build() {
            if (this.user == null || this.totalPrice == null || this.items == null || this.deliveryAddress == null)
                throw new IllegalStateException("Not enough data!");
            return new Order(this.totalPrice, this.user, this.items, this.deliveryAddress);
        }
    }
}
