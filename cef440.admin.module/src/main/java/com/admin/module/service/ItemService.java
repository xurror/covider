package com.admin.module.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.module.dto.ItemDTO;



public interface ItemService {

	List<ItemDTO> retrieveItems();
//	List<UserDTO> retrieveNMUsers(); 
//	List<UserDTO> retrieveAgentUsers();
//	List<UserDTO> retrieveAdminUsers();
	
	ItemDTO retrieveItem(int itemId);

	ItemDTO createItem(ItemDTO newItemDTO, int itemLocation);
	void deleteItem(int itemId);
	void editItem(int itemId, int locationId, ItemDTO newItemDTO);
	
}
