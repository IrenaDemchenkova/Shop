package ru.irendemchenkova.shop.items.types;

import ru.irendemchenkova.shop.items.Item;
import ru.irendemchenkova.shop.items.ItemSize;

import java.util.Calendar;

public class NonFoodItem extends Item {
    private final ItemSize itemSize;

    public NonFoodItem(String id, String description, int startQuantity, double price, ItemSize itemSize) {
        super(id, description, startQuantity, price);
        this.itemSize = itemSize;
    }

    public ItemSize getItemSize() {
        return itemSize;
    }

    @Override
    public String toString() {
        return "NonFoodItem{" +
                "id=" + getId() +
                ", description=" + getDescription() +
                ", quantity=" + getQuantity() + " items" +
                ", price=" + getPrice() + " rubles per item" +
                ", itemSize=" + itemSize +
                '}';
    }

    public static final class Builder {
        private String id;
        private String description;
        private Integer startQuantity;
        private Double price;
        private ItemSize size;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStartQuantity(int startQuantity) {
            this.startQuantity = startQuantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setSize(ItemSize size) {
            this.size = size;
            return this;
        }

        public NonFoodItem build() {
            if (this.id == null || this.description == null || this.startQuantity == null || this.price == null || this.size == null)
                throw new IllegalStateException("Not enough data!");
            return new NonFoodItem(this.id, this.description, this.startQuantity, this.price, this.size);
        }
    }
}
