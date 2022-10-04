package com.kimmayer.springbootmaster.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ServerController {
    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> serveDishes() {
        return this.kitchen.getDishes();
    }

    @GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> deliverDishes() {
        return this.kitchen.getDishes()
                .map(Dish::deliver);
    }

    @PostMapping(value = "/create-item", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Mono<Item> createItem() {
        return this.kitchen.createItem();
    }

    @GetMapping(value = "/get-item/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Mono<Item> getItem(@PathVariable String id) {
        return this.kitchen.getItem(id);
    }
}
