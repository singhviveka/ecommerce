package com.vivek.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id")
    Account user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "id")
    Address address;
    @OneToMany(mappedBy = "productOrder")
    List<Inventory> products;
    String timeOfOrder;
    int assemblingTimeInDays;
    int assemblingRate;
    int assemblingCharge;
    int totalPriceOfProduct;
    int totalAmountToPay;
    boolean isDelivered;
	
	public ProductOrder() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getUser() {
		return user;
	}
	public void setUser(Account user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Inventory> getProducts() {
		return products;
	}
	public void setProducts(List<Inventory> products) {
		this.products = products;
	}
	public String getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(String timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
	public int getAssemblingTimeInDays() {
		return assemblingTimeInDays;
	}
	public void setAssemblingTimeInDays(int assemblingTimeInDays) {
		this.assemblingTimeInDays = assemblingTimeInDays;
	}
	public int getAssemblingRate() {
		return assemblingRate;
	}
	public void setAssemblingRate(int assemblingRate) {
		this.assemblingRate = assemblingRate;
	}
	public int getAssemblingCharge() {
		return assemblingCharge;
	}
	public void setAssemblingCharge(int assemblingCharge) {
		this.assemblingCharge = assemblingCharge;
	}
	public int getTotalPriceOfProduct() {
		return totalPriceOfProduct;
	}
	public void setTotalPriceOfProduct(int totalPriceOfProduct) {
		this.totalPriceOfProduct = totalPriceOfProduct;
	}
	public int getTotalAmountToPay() {
		return totalAmountToPay;
	}
	public void setTotalAmountToPay(int totalAmountToPay) {
		this.totalAmountToPay = totalAmountToPay;
	}
	public boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
}
