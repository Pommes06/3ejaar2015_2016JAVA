package be.groept.ie4.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Order {
	
	//TODO BEWARE do NOT name your table ORDER since this is a RESERVED keyword in SQL!

    private long order_id;
    private String paymentMethod;
    private BigDecimal orderTotal;
    private Collection<OrderDetail> orderDetails = new ArrayList<>();
    private Eshop eshop;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Eshop getEshop() {
        return eshop;
    }

    public void setEshop(Eshop eshop) {
        this.eshop = eshop;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderTotal(){

        BigDecimal total = new BigDecimal(0);
        for(OrderDetail od:this.orderDetails){
            total.add(od.getTotal());
        }
         this.orderTotal = total;
    }
}
