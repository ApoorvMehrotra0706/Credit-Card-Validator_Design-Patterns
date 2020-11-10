package cmpe202.IndividualProject;

public class DiscoverCC extends CreditCard {
	private String typeOfCard;

	public DiscoverCC(String cardNumber, String expirationDate, String nameOfCardHolder) {
		super(cardNumber, expirationDate, nameOfCardHolder);
		this.typeOfCard = "Discover";
	}
	
	public String getTypeOfCard() {
		return this.typeOfCard;
	}
	
	

}
