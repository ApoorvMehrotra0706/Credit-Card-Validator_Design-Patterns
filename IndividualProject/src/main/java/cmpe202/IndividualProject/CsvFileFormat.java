package cmpe202.IndividualProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;



public class CsvFileFormat implements FileFormat {

	public List<CreditCard> getCreditCardDetails(String filePath) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		CardDetectorFactory cardDetectorFactory;
		List<CreditCard> list = new ArrayList<CreditCard>();
		try{
			br = new BufferedReader(new FileReader(filePath));
			int i = 0;
			while ((line = br.readLine()) != null) {
				if(i > 0)  {
					String[] nextRecord = line.split(cvsSplitBy);
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
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(outputFile);
			try {
				csvWriter.append("CardNumber");
				csvWriter.append(",");
				csvWriter.append("TypeOfCard");
				csvWriter.append("\n");
				for(CreditCard c : cc) {
					String[] data = new String[2];
					data[0] = c.getCardNumber();
					data[1] = c.getTypeOfCard();
					csvWriter.append(String.join(",", data));
					csvWriter.append("\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			csvWriter.flush();
			csvWriter.close();	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
