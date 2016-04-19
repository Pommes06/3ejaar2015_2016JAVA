package be.groept.ie4.entities.types;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class Password implements Serializable {

	private String password;
	private String clearText;

	public Password(String clearText) {
		this.clearText = clearText;
	}

	Password(String clearText, String password) {
		this.password = password;
		this.clearText = clearText;
	}

	public String getPassword() {
		return password;
	}

	public String getClearText() {
		return clearText;
	}

	public void setClearText(String clearText) {
		this.clearText = clearText;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}