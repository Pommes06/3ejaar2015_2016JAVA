
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Address">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Municipality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Postalcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Housenumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "age",
    "address"
})
@XmlRootElement(name = "SendPerson")
public class SendPerson {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Age")
    protected int age;
    @XmlElement(name = "Address", required = true)
    protected SendPerson.Address address;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link SendPerson.Address }
     *     
     */
    public SendPerson.Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendPerson.Address }
     *     
     */
    public void setAddress(SendPerson.Address value) {
        this.address = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Municipality" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Postalcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Housenumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "country",
        "municipality",
        "postalcode",
        "street",
        "housenumber",
        "index"
    })
    public static class Address {

        @XmlElement(name = "Country", required = true)
        protected String country;
        @XmlElement(name = "Municipality", required = true)
        protected String municipality;
        @XmlElement(name = "Postalcode")
        protected int postalcode;
        @XmlElement(name = "Street", required = true)
        protected String street;
        @XmlElement(name = "Housenumber", required = true)
        protected String housenumber;
        @XmlElement(name = "Index", required = true)
        protected String index;

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Gets the value of the municipality property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMunicipality() {
            return municipality;
        }

        /**
         * Sets the value of the municipality property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMunicipality(String value) {
            this.municipality = value;
        }

        /**
         * Gets the value of the postalcode property.
         * 
         */
        public int getPostalcode() {
            return postalcode;
        }

        /**
         * Sets the value of the postalcode property.
         * 
         */
        public void setPostalcode(int value) {
            this.postalcode = value;
        }

        /**
         * Gets the value of the street property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStreet() {
            return street;
        }

        /**
         * Sets the value of the street property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStreet(String value) {
            this.street = value;
        }

        /**
         * Gets the value of the housenumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHousenumber() {
            return housenumber;
        }

        /**
         * Sets the value of the housenumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHousenumber(String value) {
            this.housenumber = value;
        }

        /**
         * Gets the value of the index property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndex() {
            return index;
        }

        /**
         * Sets the value of the index property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndex(String value) {
            this.index = value;
        }

    }

}
