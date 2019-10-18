package com.reza.bookstore.axa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reza.bookstore.axa.model.Inventory;
import com.reza.bookstore.axa.repository.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@PutMapping("/update/{bookID}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable(value="bookID")Long bookID,
	@Valid @RequestBody Inventory detailinventory){
		
	Inventory inventory = (Inventory) inventoryRepository.findByBookID(bookID);
		
	if(inventory == null)
		return ResponseEntity.notFound().build();
	
	Inventory upInventory = inventoryRepository.save(inventory);
	return ResponseEntity.ok(upInventory);
	}
	
	@GetMapping("/search/{bookID}")
	public List<Inventory> search(@PathVariable(value="bookID")Long bookID){
		return inventoryRepository.findByBookID(bookID);
	}

}
