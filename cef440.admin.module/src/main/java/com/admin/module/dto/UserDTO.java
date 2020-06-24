package com.admin.module.dto;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.admin.module.model.user.UserType;

//import com.admin.module.model.user.UserType;

import lombok.Data;

@Data
public class UserDTO {

	private Long userId;
	private String userFullName;
	private String userName;
	private String userEmail;
	private Date userDOB;
	private String userPassword;
	private UserType userType;
	private transient String userDateOfBirthString;

	public UserDTO() {
		
	}

	public UserDTO(Long userId, String userFullName, String userName, String userEmail, Date userDOB,
			String userPassword, UserType userType, String userDateOfBirthString) {
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
		return "UserDTO [userId=" + userId + ", userFullName=" + userFullName + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userDOB=" + userDOB + ", userPassword=" + userPassword + ", userType="
				+ userType + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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
	
	public String getUserDateOfBirthString() {
		return userDOB.toString();
	}

	public void setUserDateOfBirthString(String userDateOfBirthString) {
		this.userDateOfBirthString = userDateOfBirthString;
	}
	
	
	
	

/*
 * public class AllUserDTO extends UserDTO {
 * 
 * }
 * 
 * public class NMUserDTO extends UserDTO {
 * 
 * }
 * 
 * public class AgentUserDTO extends UserDTO {
 * 
 * }
 * 
 * public class AdminUserDTO extends UserDTO {
 * 
 * }
 */
}