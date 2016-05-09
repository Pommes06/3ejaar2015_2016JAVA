package be.groept.chat;

import exerciceone.OrderServicePortType;
import exerciceone.SaveOrder;
import mypackage.PersonServicePortType;
import mypackage.SendPerson;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.List;


@WebService(endpointInterface = "exerciceone.OrderServicePortType")
public class OrderServiceImpl implements OrderServicePortType {


    @Override
    public void saveOrder(String orderName, XMLGregorianCalendar orderDate, BigDecimal totalOrderPrice, List<SaveOrder.Products> products) {

        System.err.println("Ordername: " +orderName);

    }
}
