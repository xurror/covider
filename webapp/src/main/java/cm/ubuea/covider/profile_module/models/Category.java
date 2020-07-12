package cm.ubuea.covider.profile_module.models;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import lombok.Data;

/**
 *
 * @author TERT
 */
//@Data
@Entity
@Table(name="Category_Table")
public class Category {
    
  //  @ApiModelProperty(notes = "The database generated category ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CatId;
    
  //  @ApiModelProperty(notes = "The name of category")
    @NotNull
    @Column(name="category_name", length=50)
    private String name;
    
   
    
    
//    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
 //   private List<Product> product;
    
    public Category() {
    	
    }

	public Category(long catId) {
		super();
		CatId = catId;
	}

	public Category(long CatId, String name /*, List<Product> product*/) {
		super();
		this.CatId = CatId;
		this.name = name;
		//this.product = product;
	}

	public long getId() {
		return CatId;
	}

	public void setId(long CatId) {
		this.CatId = CatId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [CatId=" + CatId + ", name=" + name + "]";
	}
}