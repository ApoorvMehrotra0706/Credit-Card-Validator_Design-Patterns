package cmpe202.IndividualProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JsonFileFormatTest {

    @Test
    public void TestgetCreditCardDetails(){
        String filePath = "C:\\202\\Test.json";
        FileFactory fileFactory = new FileFactory();
		FileFormat f = fileFactory.checkFileFormat(filePath);
        List<CreditCard> list = f.getCreditCardDetails(filePath);
        // List<CreditCard> expected = new ArrayList<CreditCard>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void TestwriteFile(){
        String filePath = "C:\\202\\Test.json";
        String outputFile = "C:\\202\\TestOutput.json";
        FileFactory fileFactory = new FileFactory();
		FileFormat f = fileFactory.checkFileFormat(filePath);
        List<CreditCard> list = f.getCreditCardDetails(filePath);
        f.writeFile(list, outputFile);
        File filecheck = new File(outputFile);
        assertTrue(filecheck.exists());
    }

    @Test
    public void TestwriteFileDataCheck(){
        String filePath = "C:\\202\\Sample.json";
        String outputFile = "C:\\202\\TestOutputData.json";
        FileFactory fileFactory = new FileFactory();
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
