package cmpe202.IndividualProject;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileFormat {
	
	public List<CreditCard> getCreditCardDetails(String filePath);
	
	public void writeFile(List<CreditCard> cc, String outputFile);
	
}
