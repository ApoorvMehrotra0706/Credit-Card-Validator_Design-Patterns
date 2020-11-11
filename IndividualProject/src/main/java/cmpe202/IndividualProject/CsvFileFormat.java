package cmpe202.IndividualProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;



public class CsvFileFormat implements FileFormat {

	public List<CreditCard> getCreditCardDetails(String filePath) {
		FileReader filereader;
		CardDetectorFactory cardDetectorFactory;
		List<CreditCard> list = new ArrayList<CreditCard>();
		try {
			filereader = new FileReader(filePath);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			int i = 0;
			while ((nextRecord = csvReader.readNext()) != null) { 
				if(i > 0) {
					String cardNumber = nextRecord[0];
					String expirationDate = nextRecord[1];
					String nameOfCardholder = nextRecord[2];
					cardDetectorFactory = new CardDetectorFactory();
					CreditCard creditCard = cardDetectorFactory.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
					list.add(creditCard);
				}
				i++; 
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   
		return list;
	}

	public void writeFile(List<CreditCard> cc, String outputFile) {
		
    	CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(outputFile, true));
			String [] heading = "CardNumber,TypeOfCard".split(",");

    		writer.writeNext(heading);
			for(CreditCard c : cc) {
				String[] data = new String[2];
				data[0] = c.getCardNumber();
				data[1] = c.getTypeOfCard();
				
				writer.writeNext(data);
			}
    		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

    	
	}

}
