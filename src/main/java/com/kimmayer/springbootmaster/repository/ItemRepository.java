package com.kimmayer.springbootmaster.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.kimmayer.springbootmaster.reactive.Item;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
