package eshop.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category {
	@Id
	@GeneratedValue
	Integer Id;
	String name;
	String nameVN;
	@OneToMany(mappedBy="category")
	Collection<Product> products;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameVN() {
		return nameVN;
	}
	public void setNameVN(String nameVN) {
		this.nameVN = nameVN;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
}
