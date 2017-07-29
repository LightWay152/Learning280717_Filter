package eshop.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {
	@Id
	String Id;
	
	Boolean activated;
	String password;
	String fullname;
	String email;
	String photo;
	@OneToMany(mappedBy="customer")
	Collection<Order> Orders;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Collection<Order> getOrders() {
		return Orders;
	}
	public void setOrders(Collection<Order> orders) {
		Orders = orders;
	}
	
	
}
