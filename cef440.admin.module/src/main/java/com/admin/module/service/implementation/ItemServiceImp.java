package com.admin.module.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.module.dto.ItemDTO;
import com.admin.module.model.Item;
import com.admin.module.model.Location;
import com.admin.module.repository.ItemRepository;
import com.admin.module.repository.LocationRepository;
import com.admin.module.service.ItemService;


@Service
public class ItemServiceImp implements ItemService{

	private ItemRepository itemRepository;

	private LocationRepository locationRepository;

	

	@Autowired
	public ItemServiceImp(ItemRepository itemRepository, LocationRepository locationRepository) {
		super();
		this.itemRepository = itemRepository;
		this.locationRepository = locationRepository;
		
	}



	@Override
	public List<ItemDTO> retrieveItems() {
		// TODO Auto-generated method stub
		Iterable<Item> items = itemRepository.findAll();
        
        return loadItemDTOS(items);
	}
	
	
	
	
	
	@Override
	public ItemDTO retrieveItem(int itemId) {
		// TODO Auto-generated method stub
		Optional<Item> itemOptional = itemRepository.findById(itemId);
		if(itemOptional.isPresent()) {
            Item item = itemOptional.get();
            ItemDTO itemDTO = copyItemtoItemDTO(item);
            return  itemDTO;
        } else {
            throw new ResourceNotFoundException("Item with Item_Id = "+ itemId + " does not exist");
        }
	}
	

	
		
	public List<ItemDTO> loadItemDTOS(Iterable<Item> items) {
		
		List<ItemDTO> itemDTOS = new ArrayList<>();
		for(Item item : items){
            
            itemDTOS.add(copyItemtoItemDTO(item));
            
        }
		return itemDTOS;
	}

	@Override

	public ItemDTO createItem(ItemDTO newItemDTO, int itemLocation) {
		// TODO Auto-generated method stub
		Item item = new Item();
		Optional<Location> location = locationRepository.findById(itemLocation);
		if(location.isPresent()) {
		item = copyItemDTOtoItem(newItemDTO, location);

		item = itemRepository.save(item);
		
		return copyItemtoItemDTO(item);
		} else {
			throw new ResourceNotFoundException("Could not find Location with Id "+itemLocation);
		}
	}

	


	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(itemId);
	}



	@Override
	public void editItem(int itemId, int locationId, ItemDTO newItemDTO) {
		// TODO Auto-generated method stub
		
		if(itemRepository.existsById(itemId)) {
			Item itemToEdit = itemRepository.findById(itemId).get();
			if(!locationRepository.existsById(locationId)) {
				throw new ResourceNotFoundException("Could not find Location with Id "+locationId);
			}
			Optional<Location> locationOpt = locationRepository.findById(locationId);
			itemToEdit = copyItemDTOtoItem(newItemDTO, locationOpt);
			itemToEdit.setItemId(itemId);
			Location location = locationOpt.get();
			Location newLocation = location;
			newLocation.setLocationId(itemToEdit.getLocationId());
			newLocation.setDivision(itemToEdit.getLocationDivision());
			newLocation.setRegion(itemToEdit.getLocationRegion());
			newLocation.setTown(itemToEdit.getLocationTown());
			itemToEdit.putItemLocation(newLocation);


			itemRepository.save(itemToEdit);
			
		}else {
            throw new ResourceNotFoundException("Requested Item not found: UserId--> " + itemId);
        }
	}
	
	
	
	public ItemDTO copyItemtoItemDTO(Item item) {
		ItemDTO itemDTO = new ItemDTO();
        
        itemDTO.setItemId(item.getItemId());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setItemCategory(item.getItemCategory());
        

        itemDTO.setItemLocation(item.getItemLocation());

        
        return itemDTO;
    }
	

	public Item copyItemDTOtoItem(ItemDTO newItemDTO, Optional<Location> location) {


		Item item = new Item();
		

		item.setItemLocation(location.get());

		item.setItemName(newItemDTO.getItemName());
		item.setItemCategory(newItemDTO.getItemCategory());
		 
        return item;
    }


}
