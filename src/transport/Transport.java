package transport;

import java.util.Objects;

public abstract class Transport {
    private final String model;
    private final String brand;
    private final int year;
    private final String country;
    private String color;
    private int maximumSpeed;

    public Transport(String model, String brand, int year, String country, String bodyColor, int maximumSpeed) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "по умолчанию";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "по умолчанию";
        } else {
            this.model = model;
        }
        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "по умолчанию";
        } else {
            this.country = country;
        }
        if (bodyColor == null || bodyColor.isEmpty() || bodyColor.isBlank()) {
            this.color = "белый";
        } else {
            this.color = bodyColor;
        }
        if (maximumSpeed <= 0) {
            this.maximumSpeed = 120;
        } else {
            this.maximumSpeed = maximumSpeed;
        }
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty() || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        if (maximumSpeed <= 0) {
            this.maximumSpeed = 180;
        } else {
            this.maximumSpeed = maximumSpeed;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return year == transport.year && maximumSpeed == transport.maximumSpeed && Objects.equals(model, transport.model) && Objects.equals(brand, transport.brand) && Objects.equals(country, transport.country) && Objects.equals(color, transport.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, brand, year, country, color, maximumSpeed);
    }
}
