package com.admin.module.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.admin.module.model.user.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

public class LocationDTO {
		
		private int locationId;
		private String region;
		private String division;
		private String town;
		private List<Users> users;
		
		public LocationDTO() {
			
		}
		
		
		public LocationDTO(int locationId, String region, String division, String town) {
			super();
			this.locationId = locationId;
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

		
	 public List<Users> takeUsers() { return users; }
	
	  
	  public void putUsers(List<Users> users) { this.users = users; }
	 
		
		
}
