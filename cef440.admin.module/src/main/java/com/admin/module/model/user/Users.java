package com.admin.module.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.admin.module.model.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name = "USER_tbl")
@Inheritance(strategy = InheritanceType.JOINED) // JOINED and comment next line
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Users implements Serializable{

	// @Size(min = 5, max = 60, message = "Name must be between 5 to 60 characters")

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	@Column(name = "USER_ID", columnDefinition = "bigint(10)", length = 8)
	private int userId;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="locationId", nullable=false)
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location userLocation;



	@Column(name = "USER_FULLNAME", unique = true, nullable = false, columnDefinition = "varchar(50) NOT NULL", length = 50)
	private String userFullName;

	@Column(name = "USER_NAME", nullable = false, columnDefinition = "varchar(10) NOT NULL", length = 10)
	private String userName;

	@Column(name = "USER_EMAIL", nullable = false, columnDefinition = "varchar(50) default 'john.doe@email.com'", length = 50)
	private String userEmail;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "USER_DOB", nullable = false, columnDefinition = "date")
	private Date userDOB;

	@Column(name = "PASSWORD", nullable = false, columnDefinition = "varchar(32)", length = 32)
	private String userPassword;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "USER_TYPE", nullable = false, columnDefinition = "varchar(8)", length = 8)
	private UserType userType;

	@Transient
	private transient String userDateOfBirthString;
	
	

	public Users() {

	}

	public Users(int userId, String userFullName, String userName, String userEmail, Date userDOB, String userPassword,
			UserType userType,  String userDateOfBirthString) {

		super();
		this.userId = userId;
		this.userFullName = userFullName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userDOB = userDOB;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userDateOfBirthString = userDateOfBirthString;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userFullName=" + userFullName + ", userName=" + userName + ", userEmail="
				+ userEmail + ", userDOB=" + userDOB + ", userPassword=" + userPassword + ", userType=" + userType
				+ "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	// to display on view
	public String getUserDateOfBirthString() {
		return userDOB.toString();
	}

	public void setUserDateOfBirthString(String userDateOfBirthString) {
		this.userDateOfBirthString = userDateOfBirthString;
	}
	
	
	
	@JsonIgnore
	public int getLocationId() {
		return userLocation.getLocationId();
	}
	
	@JsonIgnore
	public String getLocationRegion() {
		return userLocation.getRegion();
	}
	
	@JsonIgnore
	public String getLocationDivision() {
		return userLocation.getDivision();
	}
	
	@JsonIgnore
	public String getLocationTown() {
		return userLocation.getTown();
	}
	
	
	public Location getUserLocation() {
		return  userLocation;
	}
	
	public Location getUserLocation_1() {
		return new Location(getLocationId(), getLocationRegion(), getLocationDivision(), getLocationTown());
	}
	
	@JsonIgnore
	public void setUserLocation() {
			this.userLocation = new Location(getLocationId(), getLocationRegion(), getLocationDivision(), getLocationTown());
	}
	
	@JsonIgnore
	public void putUserLocation(Location location) {
		this.userLocation = location;
	}
	


}
