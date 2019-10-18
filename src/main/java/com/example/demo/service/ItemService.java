package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepo;
	
	public void storeItem(Item item) {
		itemRepo.save(item);		
	}
	
	
	public List<Item> findAllItems() {
	
		List<Item> allItems = itemRepo.findAll();
		return allItems;
	}
	
}
