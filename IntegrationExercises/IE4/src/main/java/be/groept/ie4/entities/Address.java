package be.groept.ie4.entities;

public class Address {

	private Eshop eshop;
    private Long eshop_id;
    private String country;
    private String municipality;
    private String postalcode;
    private String street;
    private String housenumber;
    private String box;

    public Eshop getEshop() {
        return eshop;
    }

    public void setEshop(Eshop eshop) {
        this.eshop = eshop;
    }

    public Long getEshop_id() {
        return eshop_id;
    }

    public void setEshop_id(Long eshop_id) {
        this.eshop_id = eshop_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}
