package be.groept.chat;

import mypackage.PersonServicePortType;
import mypackage.SendPerson;

import javax.jws.WebService;


@WebService(endpointInterface = "mypackage.PersonServicePortType")
public class PersonServiceImpl implements PersonServicePortType {
    @Override
    public void sendPerson(String name, int age, SendPerson.Address address) {

        System.err.println("Name: " +name);
        System.err.println("Age: " +age);
        System.err.println("Straat: " +address.getStreet());
        System.err.println("PostCode: " +address.getPostalcode());
        System.err.println("City: " +address.getMunicipality());




    }
}
