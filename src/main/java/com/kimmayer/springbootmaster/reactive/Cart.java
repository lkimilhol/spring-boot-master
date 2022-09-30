package com.kimmayer.springbootmaster.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Cart {
    private @Id String id;
    private List<CarItem> carItems;

    private Cart() {}

    public Cart(String id) {
        this(id, new ArrayList<>());
    }

    public Cart(String id, List<CarItem> carItems) {
        this.id = id;
        this.carItems = carItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarItem> getCarItems() {
        return carItems;
    }

    public void setCarItems(List<CarItem> carItems) {
        this.carItems = carItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(carItems, cart.carItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carItems);
    }
}
