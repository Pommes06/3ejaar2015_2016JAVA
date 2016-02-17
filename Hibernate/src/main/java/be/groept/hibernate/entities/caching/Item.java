package be.groept.hibernate.entities.caching;

public class Item {

	private Long id;

	private Description itemDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Description getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(Description itemDescription) {
		this.itemDescription = itemDescription;
	}

}
