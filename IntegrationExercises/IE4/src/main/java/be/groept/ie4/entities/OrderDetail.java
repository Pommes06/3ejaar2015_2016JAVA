package be.groept.ie4.entities;

import java.math.BigDecimal;

public class OrderDetail {

	private long orderdetail_id;
    private Order order;
    private Product product;
    private BigDecimal amount;
    private BigDecimal total;

    public long getOrderdetail_id() {
        return orderdetail_id;
    }

    public void setOrderdetail_id(long orderdetail_id) {
        this.orderdetail_id = orderdetail_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
