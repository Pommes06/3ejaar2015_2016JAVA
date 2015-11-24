package be.groept.jsf;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import be.groept.jsf.model.Order;
import be.groept.jsf.model.OrderSearchCriteria;
import be.groept.jsf.model.OrderServiceImpl;

@ManagedBean(name="search")
@SessionScoped
public class SearchBean {

    public SearchBean() {
        this.orderSearchCriteria = new OrderSearchCriteria();
        this.orderServiceImpl = new OrderServiceImpl();
        this.searched = false;
        // this.foundorders = null;
        this.orders = this.orderServiceImpl.getAllOrdersForCustomer();

    }

    public void reset(ActionEvent actionEvent){
        this.orderSearchCriteria = new OrderSearchCriteria();
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

        if (this.orderSearchCriteria.getEmail() == ""
                || !(this.orderSearchCriteria.getMaxAmount() != null)) {
            FacesContext.getCurrentInstance().addMessage("backingmsg",
                    new FacesMessage("problem"));
        } else {
            this.foundorders = this.orderServiceImpl
                    .searchOrders(this.orderSearchCriteria);
            // return this.foundorders;
        }

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
        this.orderSearchCriteria.setDelivered(null);
        this.orderSearchCriteria.setMaxAmount(null);
        this.orderSearchCriteria.setMinAmount(null);
        this.orderSearchCriteria.setNumberOfProducts(null);
        this.orderSearchCriteria.setProductName(null);
        this.foundorders = null;
        RequestContext.getCurrentInstance().reset("form");

    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}