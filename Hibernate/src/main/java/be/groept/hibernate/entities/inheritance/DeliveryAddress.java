package be.groept.hibernate.entities.inheritance;

public class DeliveryAddress extends Address {

	private boolean allowNeighbourDelivery;

	public boolean isAllowNeighbourDelivery() {
		return allowNeighbourDelivery;
	}

	public void setAllowNeighbourDelivery(boolean allowNeighbourDelivery) {
		this.allowNeighbourDelivery = allowNeighbourDelivery;
	}
}
