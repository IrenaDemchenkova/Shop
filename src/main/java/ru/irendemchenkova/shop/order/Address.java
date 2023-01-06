package ru.irendemchenkova.shop.order;

public class Address {
    private final String country;
    private final String city;
    private final String street;
    private final int buildingNo;

    public Address(String country, String city, String street, int buildingNo) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.buildingNo = buildingNo;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s %s", this.country, this.city, this.street, this.buildingNo);
    }

    public static final class Builder {
        private String country;
        private String city;
        private String street;
        private Integer buildingNo;

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setBuildingNo(int buildingNo) {
            this.buildingNo = buildingNo;
            return this;
        }

        public Address build() {
            if (country == null || city == null || street == null || buildingNo == null)
                throw new IllegalStateException("Not enough data!");
            return new Address(country, city, street, buildingNo);
        }
    }
}
