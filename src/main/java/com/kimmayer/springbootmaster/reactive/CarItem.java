package com.kimmayer.springbootmaster.reactive;

import java.util.Objects;

public class CarItem {

    private Item item;
    private int quantity;

    private CarItem() {}

    CarItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarItem carItem = (CarItem) o;
        return quantity == carItem.quantity && Objects.equals(item, carItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity);
    }
}
