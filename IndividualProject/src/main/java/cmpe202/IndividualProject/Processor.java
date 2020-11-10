package cmpe202.IndividualProject;

import java.util.List;

public class Processor {
    
    public void processCard(String inputFile, String outputFile) {
		FileFactory fileFactory = new FileFactory();
		FileFormat f = fileFactory.checkFileFormat(inputFile);
		List<CreditCard> list = f.getCreditCardDetails(inputFile);
		System.out.println(list);
		f.writeFile(list, outputFile);
    }
}
