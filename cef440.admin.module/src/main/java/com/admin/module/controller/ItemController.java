package com.admin.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.module.dto.ItemDTO;
import com.admin.module.service.ItemService;
import com.admin.module.service.ItemService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ItemController {

	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	
	@GetMapping("/items")
	public ResponseEntity<List<ItemDTO>> getAllItems(){
		return ResponseEntity.ok(itemService.retrieveItems());
	}
	

	@PostMapping("/item/location/{locationId}")
	public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO newItemDTO, @PathVariable("locationId") int locationId) {
		ItemDTO itemDTO = itemService.createItem(newItemDTO, locationId);

		return new ResponseEntity<> (itemDTO,HttpStatus.CREATED);
		
	}

	
	@GetMapping("/item/{itemId}")
	public ResponseEntity<ItemDTO> getItem(@PathVariable int itemId){
		return ResponseEntity.ok().body(itemService.retrieveItem(itemId));
	}
	
	@DeleteMapping("/item/{itemId}")
	public ResponseEntity<Object> deleteItem(@PathVariable int itemId) {
		itemService.deleteItem(itemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/item/{itemId}/location/{locationId})")
	public ResponseEntity<Object> editItem(@PathVariable("itemId") int itemId, @PathVariable("locationId") int locationId, @RequestBody ItemDTO newItemDTO) {
		itemService.editItem(itemId, locationId, newItemDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
