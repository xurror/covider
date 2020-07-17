package com.admin.module.dto;


import com.admin.module.model.Location;

public class ItemDTO {

	private int itemId;
	private String itemName;	
	private String itemCategory;
	private Location itemLocation;
	
	
	
	
	public ItemDTO() {
		
	}




	public ItemDTO(int itemId, String itemName, String itemCategory, Location itemLocation) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemLocation = itemLocation;
	}




	public int getItemId() {
		return itemId;
	}




	public void setItemId(int itemId) {
		this.itemId = itemId;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public String getItemCategory() {
		return itemCategory;
	}




	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}




	public Location getItemLocation() {
		return itemLocation;
	}




	public void setItemLocation(Location itemLocation) {
		this.itemLocation = itemLocation;
	}
	
	
	
	
	
	
}
