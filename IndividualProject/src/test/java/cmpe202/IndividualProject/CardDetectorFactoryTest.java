package cmpe202.IndividualProject;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardDetectorFactoryTest {

    @Test
    public void TestCheckTypeOfCardMasterCard() {
        // MasterCard
        String cardNumber = "5410000000000000";
        String expirationDate = "3/20/2030";
        String nameOfCardholder = "Alice";
        String typeOfCard = "MasterCard";
        CardDetectorFactory cardDetector = new CardDetectorFactory();
        CreditCard result = cardDetector.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
        String cardTypeDetected = result.getTypeOfCard();
        assertTrue(result instanceof MasterCC);
        assertFalse(result instanceof VisaCC);
        assertFalse(result instanceof AmExCC);
        assertSame(typeOfCard, cardTypeDetected);
    }

    @Test
    public void TestCheckTypeOfCardVisa() {
        // Visa
        String cardNumber = "4120000000000";
        String expirationDate = "4/20/2030";
        String nameOfCardholder = "Bob";
        String typeOfCard = "Visa";
        CardDetectorFactory cardDetector = new CardDetectorFactory();
        CreditCard result = cardDetector.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
        String cardTypeDetected = result.getTypeOfCard();
        assertTrue(result instanceof VisaCC);
        assertFalse(result instanceof MasterCC);
        assertFalse(result instanceof AmExCC);
        assertSame(typeOfCard, cardTypeDetected);
    }

    @Test
    public void TestCheckTypeOfCardAmEx() {
        // Visa
        String cardNumber = "341000000000000";
        String expirationDate = "5/20/2030";
        String nameOfCardholder = "Eve";
        String typeOfCard = "American-Express";
        CardDetectorFactory cardDetector = new CardDetectorFactory();
        CreditCard result = cardDetector.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
        String cardTypeDetected = result.getTypeOfCard();
        assertTrue(result instanceof AmExCC);
        assertFalse(result instanceof MasterCC);
        assertFalse(result instanceof VisaCC);
        assertSame(typeOfCard, cardTypeDetected);
    }

    @Test
    public void TestCheckTypeOfCardError() {
        // Visa
        String cardNumber = "6010000000000000";
        String expirationDate = "6/20/2030";
        String nameOfCardholder = "Richard";
        String typeOfCard = "error";
        CardDetectorFactory cardDetector = new CardDetectorFactory();
        CreditCard result = cardDetector.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
        String cardTypeDetected = result.getTypeOfCard();
        assertTrue(result instanceof CreditCard);
        assertFalse(result instanceof AmExCC);
        assertFalse(result instanceof MasterCC);
        assertFalse(result instanceof VisaCC);
        assertSame(typeOfCard, cardTypeDetected);
    }



}
