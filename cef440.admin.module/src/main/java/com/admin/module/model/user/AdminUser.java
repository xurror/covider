
  package com.admin.module.model.user;
  
  import javax.persistence.*;
  
  
  @Entity
  @DiscriminatorValue("ADMIN") 
  @PrimaryKeyJoinColumn(name="ADMIN_ID")
  public class AdminUser extends Users{
  
  
  }
 