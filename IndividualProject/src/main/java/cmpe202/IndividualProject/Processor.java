package cmpe202.IndividualProject;

import java.util.List;

public class Processor {
    
    public void processCard(String inputFile, String outputFile) {
        // String inputFile = "C:\\202\\Sample.json";
		FileFactory fileFactory = new FileFactory();
		FileFormat f = fileFactory.checkFileFormat(inputFile);
		List<CreditCard> list = f.getCreditCardDetails(inputFile);
		System.out.println(list);
		f.writeFile(list, outputFile);

		// String inputFile = "C:\\202\\Sample.xml";
		// FileFactory fileFactory = new FileFactory();
		// FileFormat f = fileFactory.checkFileFormat(inputFile);
		// List<CreditCard> list = f.getCreditCardDetails(inputFile);
		// System.out.println(list);
		// f.writeFile(list, "C:\\202\\XMLOutput.xml");

		// String inputFile = "C:\\202\\Sample.csv";
		// FileFactory fileFactory = new FileFactory();
		// FileFormat f = fileFactory.checkFileFormat(inputFile);
		// List<CreditCard> list = f.getCreditCardDetails(inputFile);
		// System.out.println(list);
		// f.writeFile(list, "C:\\202\\CSVOutput.csv");
    }
}
