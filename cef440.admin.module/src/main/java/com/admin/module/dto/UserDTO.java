package com.admin.module.dto;

import java.util.Date;

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

	public String getUserDateOfBirthString() {
		return userDOB.toString();
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