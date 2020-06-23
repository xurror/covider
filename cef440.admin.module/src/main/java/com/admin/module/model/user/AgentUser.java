
  package com.admin.module.model.user;
  
  import javax.persistence.*;
  
  
  @Entity
  @DiscriminatorValue("AGENT") 
  @PrimaryKeyJoinColumn(name="AGENT_ID")
  public class AgentUser extends Users{
  
  
  }
 