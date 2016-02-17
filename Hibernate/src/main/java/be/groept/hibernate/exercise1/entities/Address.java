package be.groept.hibernate.exercise1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public class Address {

	private Long id;

	private String country;
	private String municipality;
	private String postalCode;
	private String street;
	private String houseNumber;
	private String box;

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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
