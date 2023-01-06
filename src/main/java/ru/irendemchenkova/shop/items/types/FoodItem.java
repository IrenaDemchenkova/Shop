package ru.irendemchenkova.shop.items.types;
import ru.irendemchenkova.shop.items.Item;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FoodItem extends Item {
    private final Calendar productionDate;
    private final int shelfLife;
    private final Calendar expireDate;

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd");

    public FoodItem(String id, String description, int startQuantity, double price, Calendar productionDate, int shelfLife, Calendar expireDate) {
        super(id, description, startQuantity, price);

        this.shelfLife = shelfLife;
        this.productionDate = productionDate;
        this.expireDate = expireDate;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + getId() +
                ", description=" + getDescription() +
                ", quantity=" + getQuantity() + " kg" +
                ", price=" + getPrice() + " rubles per kg" +
                ", productionDate=" + this.dateFormatter.format(productionDate.getTime()) +
                ", shelfLife=" + shelfLife +
                ", expireDate=" + this.dateFormatter.format(expireDate.getTime()) +
                '}';
    }

    public static final class Builder {
        private String id;
        private String description;
        private Integer startQuantity;
        private Double price;
        private Calendar productionDate;
        private Integer shelfLife;
        private Calendar expireDate;

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

        public Builder setProductionDate(int year, int month, int day) {
            this.productionDate = new Calendar.Builder()
                    .setDate(year, month - 1, day)
                    .build();
            return this;
        }

        public Builder setShelfLife(int shelfLife) {
            this.shelfLife = shelfLife;
            this.expireDate = (Calendar) this.productionDate.clone();
            this.expireDate.add(Calendar.DATE, this.shelfLife);
            return this;
        }

        public FoodItem build() {
            if (this.id == null || this.description == null || this.startQuantity == null || this.price == null
                || this.productionDate == null || this.shelfLife == null)
                throw new IllegalStateException("Not enough data!");
            return new FoodItem(this.id, this.description, this.startQuantity, this.price, this.productionDate, this.shelfLife, this.expireDate);
        }
    }
}