package com.admin.module.model.user;

import javax.persistence.*;


@Entity
@DiscriminatorValue("NORMAL")
@PrimaryKeyJoinColumn(name="NUSER_ID")
public class NormalUser extends Users{
	

}
