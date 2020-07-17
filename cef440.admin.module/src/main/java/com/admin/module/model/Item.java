package com.admin.module.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "ITEM_tbl")
public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID", columnDefinition = "bigint(10)", length = 8)
	private int itemId;
	
	@Column(name = "ITEM_NAME", nullable = false, columnDefinition = "varchar(20) NOT NULL", length = 20)
	private String itemName;
	
	@Column(name = "ITEM_CATEGORY", nullable = false, columnDefinition = "varchar(20) NOT NULL", length = 20)
	private String itemCategory;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="locationId", nullable=false)
	private Location itemLocation;
	
	
	

	public Item() {
		
	}




	public Item(int itemId, String itemName, String itemCategory) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		
	}




	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemLocation="
				+ itemLocation + "]";
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




//	public Location getItemLocation() {
//		return itemLocation;
//	}




	public void setItemLocation(Location itemLocation) {
		this.itemLocation = itemLocation;
	}
	
	@JsonIgnore
	public int getLocationId() {
		return itemLocation.getLocationId();
	}
	
	@JsonIgnore
	public String getLocationRegion() {
		return itemLocation.getRegion();
	}
	
	@JsonIgnore
	public String getLocationDivision() {
		return itemLocation.getDivision();
	}
	
	@JsonIgnore
	public String getLocationTown() {
		return itemLocation.getTown();
	}
	
	
	public Location getItemLocation() {
		return  itemLocation;
	}
	
	public Location getItemLocation_1() {
		return new Location(getLocationId(), getLocationRegion(), getLocationDivision(), getLocationTown());
	}
	
	@JsonIgnore
	public void setItemLocation() {
			this.itemLocation = new Location(getLocationId(), getLocationRegion(), getLocationDivision(), getLocationTown());
	}
	
	@JsonIgnore
	public void putItemLocation(Location location) {
		this.itemLocation = location;
	}
	
	
	

}
