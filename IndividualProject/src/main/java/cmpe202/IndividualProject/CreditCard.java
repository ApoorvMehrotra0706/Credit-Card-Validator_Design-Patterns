package cmpe202.IndividualProject;

public class CreditCard {
	private String cardNumber;
	private String typeOfCard;
	private String expirationDate;
	private String nameOfCardHolder;	
	
	public CreditCard(String cardNumber, String expirationDate, String nameOfCardHolder) {
		this.cardNumber = cardNumber;
		this.typeOfCard = "error";
		this.expirationDate = expirationDate;
		this.nameOfCardHolder = nameOfCardHolder;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public String getTypeOfCard() {
		return this.typeOfCard;
	}	
}
