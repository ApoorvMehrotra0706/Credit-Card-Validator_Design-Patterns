package cmpe202.IndividualProject;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.collections.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlFileFormat implements FileFormat {

	public List<CreditCard> getCreditCardDetails(String filePath) {
		CardDetectorFactory cardDetectorFactory;
		List<CreditCard> list = new ArrayList<CreditCard>();
		try {
			File inputFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("row");
			// System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String cardNumber = eElement.getElementsByTagName("CardNumber")
					.item(0)
					.getTextContent();
					String expirationDate = eElement.getElementsByTagName("ExpirationDate")
					.item(0)
					.getTextContent();
					String nameOfCardholder = eElement.getElementsByTagName("NameOfCardholder")
					.item(0)
					.getTextContent();
					cardDetectorFactory = new CardDetectorFactory();
					CreditCard creditCard = cardDetectorFactory.checkTypeOfCard(cardNumber, expirationDate, nameOfCardholder);
					list.add(creditCard);	
				}  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void writeFile(List<CreditCard> cc, String outputFile) {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
        DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			// root element
            Element root = document.createElement("root");
			document.appendChild(root);
			for(CreditCard c : cc) {
			// employee element
				Element row = document.createElement("row");
							
				// CardNumber element
				Element cardNumber = document.createElement("CardNumber");
				cardNumber.appendChild(document.createTextNode(c.getCardNumber()));
				row.appendChild(cardNumber);
 
				// TypeOfCard elements
				Element typeOfCard = document.createElement("TypeOfCard");
				typeOfCard.appendChild(document.createTextNode(c.getTypeOfCard()));
				row.appendChild(typeOfCard);
 
				root.appendChild(row);
			}

			// create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(outputFile));
			transformer.transform(domSource, streamResult);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        
		
	}

}
