package org.example;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String brand;
    private final String name;
    private boolean onSale;

    public Car(String brand, String name, boolean onSale) {
        if(brand == null || name == null){
            throw new IllegalArgumentException();
        }

        this.brand = brand;
        this.name = name;
        this.onSale = onSale;
    }


    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isOnSale() {
        return onSale;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return onSale == car.onSale && Objects.equals(brand, car.brand) && Objects.equals(name, car.name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", onSale=" + onSale +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, name);
    }

    @Override
    public int compareTo(Car o) {
        return name.compareTo(o.name);
    }
}
