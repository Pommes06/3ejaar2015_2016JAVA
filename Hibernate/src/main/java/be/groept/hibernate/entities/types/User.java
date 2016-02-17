package be.groept.hibernate.entities.types;

public class User {

	private Long id;
	private Password password;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
