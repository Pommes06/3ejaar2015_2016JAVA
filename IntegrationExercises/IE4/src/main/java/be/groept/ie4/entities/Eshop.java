package be.groept.ie4.entities;

import java.util.ArrayList;
import java.util.List;

public class Eshop {

	private List<Order> orders = new ArrayList();
	private Address address;
	private Long eshop_id;
	private String name;
	// private EshopInfo eshopinfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(final List<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getEshop_id() {
		return eshop_id;
	}

	public void setEshop_id(Long eshop_id) {
		this.eshop_id = eshop_id;
	}

	/**
	public EshopInfo getEshopinfo() {
		return eshopinfo;
	}

	public void setEshopinfo(EshopInfo eshopinfo) {
		this.eshopinfo = eshopinfo;
	}
	 **/
}
