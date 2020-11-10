package cmpe202.IndividualProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileFactoryTest {

    @Test
    public void TestcheckFileFormatJson(){
        String filePath = "test.json";
        FileFactory result = new FileFactory();
        FileFormat format = result.checkFileFormat(filePath);
        assertTrue(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatXml(){
        String filePath = "test.xml";
        FileFactory result = new FileFactory();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertTrue(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatCsv(){
        String filePath = "test.csv";
        FileFactory result = new FileFactory();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertTrue(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatOther(){
        String filePath = "test.txt";
        FileFactory result = new FileFactory();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
        assertNull(format);
    }




}
