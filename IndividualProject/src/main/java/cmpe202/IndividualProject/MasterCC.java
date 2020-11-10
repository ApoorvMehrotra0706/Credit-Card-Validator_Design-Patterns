package cmpe202.IndividualProject;

public class MasterCC extends CreditCard {
	private String typeOfCard;
	
	public MasterCC(String cardNumber, String expirationDate, String nameOfCardHolder) {
		super(cardNumber, expirationDate, nameOfCardHolder);
		this.typeOfCard = "MasterCard";
	}

	public String getTypeOfCard() {
		return this.typeOfCard;
	}
}
