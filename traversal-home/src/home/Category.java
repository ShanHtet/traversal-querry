package home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
	private List<Product> product = new ArrayList<Product>();
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", product=" + product + "]";
	}

	protected List<Product> getProduct() {
		return product;
	}

	protected void setProduct(List<Product> product) {
		this.product = product;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}
   
}
