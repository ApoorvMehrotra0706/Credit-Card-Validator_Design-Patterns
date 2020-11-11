package cmpe202.IndividualProject;

import java.util.List;

public class Processor {
    
    public void processCard(String inputFile, String outputFile) {
		FileDetector fileDetector = new FileDetector();
		FileFormat f = fileDetector.checkFileFormat(inputFile);
		if( f != null ) {
			List<CreditCard> list = f.getCreditCardDetails(inputFile);
			f.writeFile(list, outputFile);
		} else {
			System.out.println("The current file type is not supported");
		}
    }
}
