package com.admin.module.model.user;

import java.util.Date;

import javax.persistence.*;
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
@Inheritance(strategy = InheritanceType.JOINED) //JOINED and comment next line
@DiscriminatorColumn(name="USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Users {
	
	 //@Size(min = 5, max = 60, message = "Name must be between 5 to 60 characters")
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "USER_ID", columnDefinition = "bigint(10)", length = 8) 
	  private Long userId;
	  
	  
	  //@NotNull
	  
	  //@Size(min = 5,max = 50,message = "Name must be between 5 to 50 characters")
	  
	  
	  @Column(name = "USER_FULLNAME", unique = true, nullable=false,
	  columnDefinition = "varchar(50) NOT NULL", length = 50) private String
	  userFullName;
	  
	  @Column(name = "USER_NAME", nullable=false, columnDefinition =
	  "varchar(10) NOT NULL", length = 10) private String userName;
	  
	  @Column(name = "USER_EMAIL", nullable=false, columnDefinition =
	  "varchar(50) default 'john.doe@email.com'", length = 50) private String
	  userEmail;
	  
	  @Temporal(value = TemporalType.DATE)
	  
	  @Column(name = "USER_DOB", nullable=false, columnDefinition = "date") private
	  Date userDOB;
	  
	  @Column(name = "PASSWORD", nullable=false, columnDefinition = "varchar(32)",
	  length = 32) private String userPassword;
	  
	
	  @Enumerated(value = EnumType.STRING)
	  @Column(name = "USER_TYPE", nullable=false, columnDefinition = "varchar(8)",
	  length = 8) private UserType userType;
	 
	  @Transient private transient String userDateOfBirthString;
	  
	  // to display on view 
	  public String getUserDateOfBirthString() { return userDOB.toString(); }
	 

}
