package com.in28minutes.springunittestingwithmockito.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springunittestingwithmockito.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
