package be.groept.vaadin;

import java.math.BigDecimal;

import be.groept.vaadin.model.Order;
import be.groept.vaadin.model.Product;
import be.groept.vaadin.util.Search;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class IE2_Detailview extends IE2_Template {

	@Override
	public Component getBody() {
		// retrieve the Search object for this session
		final Search searcher = (Search) VaadinSession.getCurrent()
				.getAttribute("mysearcher");

		Order order = searcher.getSelectedOrder();

		// define main layout components
		Panel orderdetailpanel = new Panel("Detail");
		VerticalLayout vl = new VerticalLayout();

		Label lborderdetail = new Label("Order Detail");

		HorizontalLayout horOrderDetail = new HorizontalLayout();
		VerticalLayout sv1 = new VerticalLayout();
		Label lborderid = new Label("OrderId:");
		Label lbnrodprods = new Label("#products:");
		Label lbdeldays = new Label("Delivery Days:");
		sv1.addComponents(lborderid, lbnrodprods, lbdeldays);

		VerticalLayout sv2 = new VerticalLayout();
		Label lbcontentorderid = new Label(order.getOrderId());
		Label lbcontentnrofprods = new Label(Integer.toString(order
				.getNrofproducts()));
		Label lbcontentdeldays = new Label(Integer.toString(order
				.getDeliveryDays()));
		sv2.addComponents(lbcontentorderid, lbcontentnrofprods,
				lbcontentdeldays);

		VerticalLayout sv3 = new VerticalLayout();
		Label lbcustid = new Label("CustomerId:");
		Label lbdelivered = new Label("Delivered:");
		Label lbtotprice = new Label("Total Price:");
		sv3.addComponents(lbcustid, lbdelivered, lbtotprice);

		VerticalLayout sv4 = new VerticalLayout();
		Label lbcontentcustid = new Label(order.getCustomerId());
		Label lbcontentdelivered = new Label(Boolean.toString(order
				.isDelivered()));
		Label lbcontenttotprice = new Label(order.getTotalOrderPrice()
				.toString());
		sv4.addComponents(lbcontentcustid, lbcontentdelivered,
				lbcontenttotprice);

		horOrderDetail.addComponents(sv1, sv2, sv3, sv4);

		Label lbproddetail = new Label("Products Detail");

		Table proddetailtable = new Table();
		proddetailtable.addContainerProperty("productId", String.class,
				"deforderid", "ProductId", null, null);
		proddetailtable.addContainerProperty("productName", String.class,
				"defcustid", "Name", null, null);
		proddetailtable.addContainerProperty("productDescription",
				String.class, "defdescr", "Description", null, null);
		proddetailtable.addContainerProperty("productPrice", BigDecimal.class,
				new BigDecimal(0), "Price", null, null);

		// adding products to the table
		for (Product prod : order.getProducts()) {
			proddetailtable.addItem(
					new Object[] { prod.getProductId(), prod.getProductName(),
							prod.getProductDescription(),
							prod.getProductPrice() }, prod.getId());
		}
		proddetailtable.setSizeFull();
		// adding css stylenames for title labels
		lborderdetail.addStyleName("HeaderLabel");
		lbproddetail.addStyleName("HeaderLabel");

		Button btback = new Button("Back");
		btback.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("main");

			}
		});

		vl.addComponents(lborderdetail, horOrderDetail, lbproddetail,
				proddetailtable, btback);
		vl.setComponentAlignment(btback, Alignment.BOTTOM_RIGHT);
		orderdetailpanel.setContent(vl);

		return orderdetailpanel;

	}
}
