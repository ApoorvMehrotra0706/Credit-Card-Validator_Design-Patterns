package cmpe202.IndividualProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileFormat implements FileFormat {

	public List<CreditCard> getCreditCardDetails(String filePath)  {
		CardDetectorFactory cardDetectorFactory;
		List<CreditCard> list = new ArrayList<CreditCard>();
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			
			JSONArray detailsObject = (JSONArray) obj;
			for(int i = 0; i < detailsObject.size(); i++) {
				JSONObject objects = (JSONObject) detailsObject.get(i);
				// JSONObject objects = ((Object) detailsObject).optJSONObject(i);
				String cardNumber = objects.get("CardNumber").toString();
				String expirationDate = (String) objects.get("ExpirationDate");
				String nameOfCardholder = (String) objects.get("NameOfCardholder"); 
				// System.out.println(cardNumber + " " + expirationDate + " " + nameOfCardholder);
				cardDetectorFactory = new CardDetectorFactory();
				CreditCard creditCard = cardDetectorFactory.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
				list.add(creditCard);
			}			    
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
      
		return list;
	}

	public void writeFile(List<CreditCard> cc, String outputFile) {
		JSONArray array = new JSONArray();
		for(CreditCard c : cc) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("CardNumber", Long.parseLong(c.getCardNumber()));
			jsonObject.put("TypeOfCard", c.getTypeOfCard());
			array.add(jsonObject);			
		}
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("result",array);
		FileWriter file = null;
		try {
			file = new FileWriter(outputFile);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonElement je = JsonParser.parseString(array.toJSONString());
			String prettyJsonString = gson.toJson(je);
			file.write(prettyJsonString);
			file.close();
		 } catch (IOException e) {
			try {
				file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		 }	
	}
}
