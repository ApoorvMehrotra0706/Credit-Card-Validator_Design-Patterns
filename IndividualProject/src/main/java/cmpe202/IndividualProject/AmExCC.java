package cmpe202.IndividualProject;

public class AmExCC extends CreditCard {
	private String typeOfCard;

	public AmExCC(String cardNumber, String expirationDate, String nameOfCardHolder) {
		super(cardNumber, expirationDate, nameOfCardHolder);
		this.typeOfCard = "American-Express";
	}
	
	public String getTypeOfCard() {
		return this.typeOfCard;
	}
	
	

}
