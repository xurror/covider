package cm.ubuea.covider.profile_module.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import lombok.Data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author collins
 */
//@Data
@Entity
@Table(name="Product_Table")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long ProdId;
    
    @Column(name="product_name")
    private String name;
    
    
    @Column(name="product_Details")
    private String Details;
    
    
    @Column(name="product_quantity")
    private int quantity;
    
    @Column(name="product_price")
    private int price;
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CatId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    
    private Category category;

    public Product() {
    	
    }
    //THE CONSTRUCTOR
	public Product(String name, String details, int quantity, int price, Category category) {
		super();
		this.name = name;
		this.Details = details;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	public long getProdId() {
		return ProdId;
	}

	public void setProdId(long prodId) {
		ProdId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
@JsonIgnore
	public Category getCategory() {
		return category;
	}
@JsonIgnore
	public void setCategory(Category category) {
		this.category = category;
	}
	
	//WILL BE USEFUL TO DISPLAY THE CATEGORY INSIDE THE PRODUCT WHEN CALLED
	@JsonIgnore
	public long getCatId() {	
		return category.getId();
	}
	
	//TO TAKE INFORMATION ABOUT THE CATEGORY SINCE IT IS IN RELATIONSHIP
	@JsonIgnore //INORDER NOT TO DISPLAY IT IN THE RESULT
	public String getCatName() {
		return category.getName();
	}
	
	public void setCatId(Long CatId) {
		category.setId(CatId);
	}

    //INITIAL DEFINATION OF CATEGORY INSIDE THE PRODUCT ON DISPLAY
	public Category getCategoryId() {
		category = new Category(getCatId(), getCatName());
		return category;
	}
     //USEFUL FOR SETTING UP THE CATEGORY IN THE DBDATA
	public void setCatId(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [ProdId=" + ProdId + ", name=" + name + ", Details=" + Details + ", quantity=" + quantity
				+ ", price=" + price + ", category=" + category + "]";
	}
}
