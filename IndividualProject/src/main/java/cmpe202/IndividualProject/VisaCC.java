package cmpe202.IndividualProject;

public class VisaCC extends CreditCard {
private String typeOfCard;
	
	public VisaCC(String cardNumber, String expirationDate, String nameOfCardHolder) {
		super(cardNumber, expirationDate, nameOfCardHolder);
		this.typeOfCard = "Visa";
	}

	public String getTypeOfCard() {
		return this.typeOfCard;
	}

}
