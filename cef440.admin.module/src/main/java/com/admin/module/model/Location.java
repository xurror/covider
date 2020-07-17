package com.admin.module.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.admin.module.model.user.UserType;
import com.admin.module.model.user.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "LOCATION_tbl")
public class Location implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID", columnDefinition = "bigint(10)", length = 8)
	private int locationId;

	@Column(name = "REGION", nullable = false, columnDefinition = "varchar(20) NOT NULL", length = 20)
	private String region;

	@Column(name = "DIVISION", nullable = true, columnDefinition = "varchar(20) default 'division'", length = 20)
	private String division;

	@Column(name = "TOWN", nullable = false, columnDefinition = "varchar(20) NOT NULL", length = 20)
	private String town;
	
	@JsonIgnore
	@OneToMany(mappedBy="userLocation")
	private List<Users> users;
	
	@JsonIgnore
	@OneToMany(mappedBy="itemLocation")
	private List<Item> item;
	

	public Location() {
		
	}
	
	
	public Location(int locationId, String region, String division, String town) {
		super();
		this.locationId = locationId;
		this.region = region;
		this.division = division;
		this.town = town;
	}
	
	public Location(String region, String division, String town) {
		super();
		this.region = region;
		this.division = division;
		this.town = town;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	@JsonIgnore
	public List<Users> getUsers() {
		return users;
	}
	
	public void setUsers(List<Users> users) {
		this.users = users;
	}

	@JsonIgnore
	public List<Item> getItem() {
		return item;
	}


	public void setItem(List<Item> item) {
		this.item = item;
	}


	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", region=" + region + ", division=" + division + ", town=" + town
				+ "]";
	}
	
	
}
