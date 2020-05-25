package de.telekom.sea.mystuff.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea.mystuff.backend.entity.Item;
import de.telekom.sea.mystuff.backend.repository.ItemRepository;

@RestController
public class ItemRestController {	
	
	private final ItemRepository repo;
	
	@RequestMapping("/api/v1/items")
	public String items() {
		
		return "items";
	}
	
	@Autowired
	public ItemRestController (ItemRepository itemRepository) {
		super();
		this.repo = itemRepository;
	}
	
	@PostMapping
	public Item addItem(@RequestBody Item items ) {
		
		return this.repo.save(items);
	}
	
	@GetMapping
	public List<Item> getItems() {
		
		return repo.findAll();
	}
	
	@RequestMapping("/api/v1/items/{id}")
	public Optional<Item> getItem(@PathVariable("id")long id) {
	
		return repo.findById(id);
	}
	
}
