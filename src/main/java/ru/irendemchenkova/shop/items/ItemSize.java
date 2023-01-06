package ru.irendemchenkova.shop.items;

public class ItemSize {
    private final double width;
    private final double height;
    private final double length;
    private final double weight;
    private final boolean isFragile;
    private final boolean isHeavy;

    public ItemSize(double width, double height, double length, double weight, boolean isFragile) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.isFragile = isFragile;
        this.isHeavy = this.weight > 50;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public boolean isHeavy() {
        return isHeavy;
    }

    @Override
    public String toString() {
        return "ItemSize{" +
                "width=" + width + " cm" +
                ", height=" + height + " cm" +
                ", length=" + length + " cm" +
                ", weight=" + weight + " cm" +
                ", isFragile=" + isFragile +
                ", isHeavy=" + isHeavy +
                '}';
    }

    public static final class Builder {
        private Double width;
        private Double height;
        private Double length;
        private Double weight;
        private Boolean isFragile;

        public Builder setWidth(double width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setLength(double length) {
            this.length = length;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setIsFragile(boolean isFragile) {
            this.isFragile = isFragile;
            return this;
        }

        public ItemSize build() {
            if (this.width == null || this.height == null || this.length == null || this.weight == null || this.isFragile == null)
                throw new IllegalStateException("Not enough data!");
            return new ItemSize(this.width, this.height, this.length, this.weight, this.isFragile);
        }
    }
}
