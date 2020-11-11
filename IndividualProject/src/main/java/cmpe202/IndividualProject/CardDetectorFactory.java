package cmpe202.IndividualProject;

public class CardDetectorFactory {
    private String cardNumber;
    private String expirationDate;
    private String nameOfCardholder;

    public CreditCard checkTypeOfCard(String cardNumber, String expirationDate, String nameOfCardholder) {
        CreditCard creditCard;
        if(cardNumber.length() <= 19) {
            if(cardNumber.charAt(0) == '5') {
                if(cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5') {
                    if (cardNumber.length() == 16) {
                        creditCard = new MasterCC(cardNumber,expirationDate,nameOfCardholder);
                        return creditCard;
                    }
                } 
            }
            else if(cardNumber.charAt(0) == '4') {
                if (cardNumber.length() == 13 || cardNumber.length() == 16) {
                    creditCard = new VisaCC(cardNumber,expirationDate,nameOfCardholder);
                    return creditCard;
                }
            }
            else if(cardNumber.charAt(0) == '3') {
                if(cardNumber.charAt(1) >= '4' || cardNumber.charAt(1) <= '7') {
                    if (cardNumber.length() == 15) {
                        creditCard = new AmExCC(cardNumber,expirationDate,nameOfCardholder);
                        return creditCard;
                    }
                } 
            }
            else if (cardNumber.substring(0, 4).compareTo("6011") == 0) {
                if(cardNumber.length() == 16) {
                    creditCard = new DiscoverCC(cardNumber,expirationDate,nameOfCardholder);
                    return creditCard;
                }
            }
        } 

        creditCard = new CreditCard(cardNumber,expirationDate,nameOfCardholder);
        return creditCard;

    }

}
