package cm.ubuea.covider.profile_module.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Location implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String name;
  private String region;
  private String division;
  private String town;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

@Override
public String toString() {
	return "Location [name=" + name + ", region=" + region + ", division=" + division + ", town=" + town + "]";
}
  
  
}
