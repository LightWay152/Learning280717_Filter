package eshop.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue
	Integer Id;
	//String customerId;
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	@Temporal(TemporalType.DATE)
	java.util.Date orderDate;
	Date requireDate;
	String receiver;
	String address;
	String description;
	Float amount;
	@OneToMany(mappedBy="order")
	Collection<OrderDetail> OrderDetails;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getRequireDate() {
		return requireDate;
	}
	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Collection<OrderDetail> getOrderDetails() {
		return OrderDetails;
	}
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		OrderDetails = orderDetails;
	}
	
	
	
}
