package cmpe202.IndividualProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class CsvFileFormatTest {

    @Test
    public void TestgetCreditCardDetails(){
        String filePath = "C:\\202\\CsvTest.csv";
        FileDetector fileFactory = new FileDetector();
		FileFormat f = fileFactory.checkFileFormat(filePath);
        List<CreditCard> list = f.getCreditCardDetails(filePath);
        assertTrue(list.isEmpty());
    }

    @Test
    public void TestwriteFile(){
        String filePath = "C:\\202\\CsvTest.csv";
        String outputFile = "C:\\202\\TestCsvOutput.csv";
        FileDetector fileFactory = new FileDetector();
		FileFormat f = fileFactory.checkFileFormat(filePath);
        List<CreditCard> list = f.getCreditCardDetails(filePath);
        f.writeFile(list, outputFile);
        File filecheck = new File(outputFile);
        assertTrue(filecheck.exists());
    }

    @Test
    public void TestwriteFileDataCheck(){
        String filePath = "C:\\202\\Sample.csv";
        String outputFile = "C:\\202\\TestCsvOutputData.json";
        FileDetector fileFactory = new FileDetector();
		FileFormat f = fileFactory.checkFileFormat(filePath);
        List<CreditCard> list = f.getCreditCardDetails(filePath);
        f.writeFile(list, outputFile);   
        BufferedReader b;
		try {
            b = new BufferedReader(new FileReader(filePath));
            assertFalse(b.readLine() == null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }


}
