package com.kimmayer.springbootmaster.reactive;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.kimmayer.springbootmaster.repository.ItemRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class KitchenService {
    private final ItemRepository itemRepository;

    public KitchenService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * 요리 스트림 생성
     */
    Flux<Dish> getDishes() {
        return Flux.<Dish> generate(sink -> sink.next(randomDish()))
                .delayElements(Duration.ofMillis(250));
    }

    Mono<Item> createItem() {
        return itemRepository.save(new Item("Alf alarm clock", 19.99));
    }

    /**
     * 요리 무작위 선택
     */
    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

    private final List<Dish> menu = Arrays.asList(
            new Dish("Sesame chicken"),
            new Dish("Lo mein noodles, plain"),
            new Dish("Sweet & sour beef"));
    private final Random picker = new Random();

    public Mono<Item> getItem(String id) {
        return itemRepository.findById(id);
    }
}
