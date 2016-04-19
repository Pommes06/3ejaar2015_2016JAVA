package be.groept.ie4.app;

import be.groept.ie4.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.groept.ie4.entities.Eshop;
import be.groept.ie4.screens.LoginScreen;
import be.groept.ie4.service.ShopService;

@Controller
public class EshopApplicationController {

	@Autowired
	private ShopService shopService;

	public void run() {
		String[] usernamePassword = getUsernamePassword();
		String username = usernamePassword[0];
		String password = usernamePassword[1];
		Customer cust = shopService.loadCustomer(username);

		while (cust.getPassword().getClearText() != password){
			usernamePassword = getUsernamePassword();
			username = usernamePassword[0];
			password = usernamePassword[1];
		}


		Eshop selectedShop = getEshop();

		while (true) {

			String selection = showMainScreen();

			if (selection.equals("1")) {
				// Make orders
			} else if (selection.equals("2")) {
				// List orders
			}
		}
	}

	private String[] getUsernamePassword() {
		return new LoginScreen().drawScreen();
	}

	private Eshop getEshop() {


		return shopService.listEshops().iterator().next();
	}

	private String showMainScreen() {
		return "";
	}
}