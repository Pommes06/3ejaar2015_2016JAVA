package be.groept.vaadin;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import be.groept.vaadin.model.Order;
import be.groept.vaadin.model.OrderSearchCriteria;
import be.groept.vaadin.util.Search;
import be.groept.vaadin.util.StringToBigDecimalConverter;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class IE2_Overview extends IE2_Template {

	@Override
	public Component getBody() {

		// retrieve the Search object from the session
		final Search searcher = (Search) VaadinSession.getCurrent()
				.getAttribute("mysearcher");

		// Vertical Layout with two panels, one for the search criteria and one
		// for the results
		VerticalLayout vl = new VerticalLayout();

		final Panel searchpanel = new Panel();
		final Panel resultpanel = new Panel();
		// starting with invisible resultpanel
		resultpanel.setVisible(false);

		/******* ResultPanel *****/

		// table with the results of the searchaction
		final Table tableresults = new Table();
		tableresults
				.addContainerProperty("orderId", String.class, "deforderid");
		tableresults.addContainerProperty("customerId", String.class,
				"defcustid");
		tableresults.addContainerProperty("nrofproducts", Integer.class, 0);
		tableresults.addContainerProperty("delivered", Boolean.class, false);
		tableresults.addContainerProperty("deliveryDays", Integer.class, 0);
		tableresults.addContainerProperty("totalOrderPrice", BigDecimal.class,
				new BigDecimal(0));
		tableresults.addContainerProperty("detail", Button.class, new Button(
				"def"));
		tableresults.setSizeFull();
		resultpanel.setContent(tableresults);
		resultpanel.setCaption("Orders Found");

		/***** SearchPanel *****/
		VerticalLayout verticalmainsearch = new VerticalLayout();
		HorizontalLayout searchHorPanelFields = new HorizontalLayout();
		HorizontalLayout searchHorPanelButtons = new HorizontalLayout();
		VerticalLayout sv1 = new VerticalLayout();
		VerticalLayout sv2 = new VerticalLayout();
		VerticalLayout sv3 = new VerticalLayout();
		VerticalLayout sv4 = new VerticalLayout();

		searchpanel.setCaption("Search Results");
		Label lbminamount = new Label("Minimum Amount");
		final TextField txminamount = new TextField();
		txminamount.setConverter(new StringToBigDecimalConverter());
		txminamount
				.setConversionError("Your min amount was not a decimal number.");
		txminamount.setNullRepresentation(null);
		txminamount.setImmediate(true);

		Label lbmaxamount = new Label("Maximum Amount");
		final TextField txmaxamount = new TextField();
		txmaxamount.setConverter(new StringToBigDecimalConverter());
		txmaxamount
				.setConversionError("Your max amount was not a decimal number.");
		txmaxamount.setNullRepresentation(null);
		txmaxamount.setImmediate(true);

		Label lbnrofprods = new Label("Number of Products");
		final TextField txnrofprods = new TextField();
		txnrofprods.setConverter(Integer.class);
		txnrofprods
				.setConversionError("Your number of products was not a decimal number.");
		txnrofprods.setNullRepresentation(null);
		txnrofprods.setImmediate(true);

		Label lbprodname = new Label("Product Name");
		final TextField txprodname = new TextField();
		txprodname.setNullRepresentation(null);

		Label lbemail = new Label("Email address");
		final TextField txemail = new TextField();
		txemail.setNullRepresentation(null);
		txemail.addValidator(new EmailValidator(
				"The email address is not in the right format"));
		txemail.setImmediate(true);

		Label lbdelivered = new Label("Delivered");
		final CheckBox chbxdelivered = new CheckBox("", false);

		sv1.addComponents(lbminamount, lbnrofprods, lbprodname);
		sv2.addComponents(txminamount, txnrofprods, txprodname);
		sv3.addComponents(lbmaxamount, lbdelivered, lbemail);
		sv4.addComponents(txmaxamount, chbxdelivered, txemail);

		searchHorPanelFields.addComponents(sv1, sv2, sv3, sv4);

		Button btclear = new Button("Clear");
		btclear.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				txemail.setValue(null);
				txmaxamount.setValue(null);
				txminamount.setValue(null);
				txnrofprods.setValue(null);
				txprodname.setValue(null);
				chbxdelivered.setValue(false);
				//empty and hide resultpanel
				resultpanel.setVisible(false);

				searcher.reset();

			}
		});
		;

		Button btsearch = new Button("Search");
		btsearch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// check the validators and converters
				if (txminamount.isValid() && txmaxamount.isValid()
						&& txnrofprods.isValid() && txemail.isValid()) {
					// creating the OrderSearchCriteria object for further
					// actions
					OrderSearchCriteria osc = new OrderSearchCriteria();
					osc.setDelivered(chbxdelivered.getValue());
					osc.setEmail(txemail.getValue());
					if (!StringUtils.isEmpty(txmaxamount.getValue())) {

						osc.setMaxAmount((BigDecimal) txmaxamount
								.getConvertedValue());

					}

					if (!StringUtils.isEmpty(txminamount.getValue())) {
						osc.setMinAmount((BigDecimal) txminamount
								.getConvertedValue());

					}
					if (!StringUtils.isEmpty(txnrofprods.getValue())) {
						osc.setNumberOfProducts((Integer) (txnrofprods
								.getConvertedValue()));
					}
					if (!StringUtils.isEmpty(txprodname.getValue())) {
						osc.setProductName(txprodname.getValue());
					}

					// checking if at least one criteria is entered

					if (osc.hasSearchCriteria()) {
						searcher.setOrderSearchCriteria(osc);
						searcher.searchorders();


						// store search results in a variable
						List<Order> foundorders = searcher.getFoundorders();

						// reinitialise Search object
						searcher.reset();


						//empty the potential previous tableresults
						tableresults.removeAllItems();

						// set table content here for each order found
						for (final Order ord : foundorders) {
							// creating the button that will store the
							// selectedorder in the Search object of the session
							Button btdet = new Button("Details");
							btdet.addClickListener(new ClickListener() {

								@Override
								public void buttonClick(ClickEvent event) {

									// store the selected order in mysearcher and store in in the session
									searcher.setSelectedOrder(ord);
									VaadinSession.getCurrent().setAttribute("mysearcher",
											searcher);
									UI.getCurrent().getNavigator()
											.navigateTo("detail");

								}
							});

							tableresults.addItem(
									new Object[] { ord.getOrderId(),
											ord.getCustomerId(),
											ord.getNrofproducts(),
											ord.isDelivered(),
											ord.getDeliveryDays(),
											ord.getTotalOrderPrice(), btdet },
									ord.getId());

						}

						resultpanel.setVisible(true);
					} else {
						Notification notif = new Notification(
								"Please enter at least one search criterium");
						notif.show(Page.getCurrent());
					}
				} else {
					Notification notifvalid = new Notification(
							"At least one of the search criteria is not valid.");
					notifvalid.show(Page.getCurrent());
				}

			}
		});

		searchHorPanelButtons.addComponents(btclear, btsearch);
		searchHorPanelButtons.setSizeUndefined();
		searchHorPanelButtons.setWidth(100, Unit.PERCENTAGE);
		searchHorPanelButtons.setComponentAlignment(btclear,
				Alignment.BOTTOM_RIGHT);

		verticalmainsearch.addComponents(searchHorPanelFields,
				searchHorPanelButtons);
		searchpanel.setContent(verticalmainsearch);

		/******/
		vl.addComponents(searchpanel, resultpanel);

		return vl;

	}
}
