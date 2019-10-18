package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/")
	public String fromItem() {
		return "Hello, Welcome to FoodOrder (From Item)";
	}
	
	
	@PostMapping("/storeItem")
	public ResponseEntity<String> saveItem(@RequestBody Item item) 
	{
		itemService.storeItem(item);
		return new ResponseEntity<String>("Item is inserted", HttpStatus.OK);
	}
	
	@GetMapping("/all-items")
	public ResponseEntity<List<Item>> findAllItems(){
		
		List<Item> allItems = itemService.findAllItems();
		
		return new ResponseEntity<List<Item>>(allItems, HttpStatus.OK);
	}
	
	
}
