package be.groept.vaadin.util;

import java.io.Serializable;
import java.util.List;

import be.groept.vaadin.model.Order;
import be.groept.vaadin.model.OrderSearchCriteria;
import be.groept.vaadin.model.OrderServiceImpl;

public class Search implements Serializable {

	public Search() {
		this.orderSearchCriteria = new OrderSearchCriteria();
		this.orderServiceImpl = new OrderServiceImpl();
		this.searched = false;
		// this.foundorders = null;
		this.orders = this.orderServiceImpl.getAllOrdersForCustomer();
		this.reset(); //initialize values
	}

	// property to test datatable
	private List<Order> orders;

	// determines whether to show the datatable
	public boolean searched;

	public boolean isSearched() {
		return searched;
	}

	public void setSearched(boolean searched) {
		this.searched = searched;
	}

	public String showOrderDetails() {
		return "orderdetail";
	}

	// on first search, the datatable will be visible using this boolean
	public void switchsearched() {
		this.searched = true;
	}

	private Order selectedOrder;

	private List<Order> foundorders;

	public List<Order> getFoundorders() {
		return foundorders;
	}

	public void setFoundorders(List<Order> foundorders) {
		this.foundorders = foundorders;
	}

	public void searchorders() {
		this.foundorders = this.orderServiceImpl
				.searchOrders(this.orderSearchCriteria);
	}

	private OrderSearchCriteria orderSearchCriteria;

	public OrderSearchCriteria getOrderSearchCriteria() {
		return orderSearchCriteria;
	}

	public void setOrderSearchCriteria(OrderSearchCriteria orderSearchCriteria) {
		this.orderSearchCriteria = orderSearchCriteria;
	}

	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public Order getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Order selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	private final OrderServiceImpl orderServiceImpl;

	public void reset() {
		this.orderSearchCriteria.setEmail(null);
		this.orderSearchCriteria.setDelivered(false);
		this.orderSearchCriteria.setMaxAmount(null);
		this.orderSearchCriteria.setMinAmount(null);
		this.orderSearchCriteria.setNumberOfProducts(null);
		this.orderSearchCriteria.setProductName(null);
		this.foundorders = null;

	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
