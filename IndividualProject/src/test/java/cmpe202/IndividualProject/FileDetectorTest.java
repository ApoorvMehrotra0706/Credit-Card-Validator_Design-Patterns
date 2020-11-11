package cmpe202.IndividualProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileDetectorTest {

    @Test
    public void TestcheckFileFormatJson(){
        String filePath = "test.json";
        FileDetector result = new FileDetector();
        FileFormat format = result.checkFileFormat(filePath);
        assertTrue(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatXml(){
        String filePath = "test.xml";
        FileDetector result = new FileDetector();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertTrue(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatCsv(){
        String filePath = "test.csv";
        FileDetector result = new FileDetector();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertTrue(format instanceof CsvFileFormat);
    }

    @Test
    public void TestcheckFileFormatOther(){
        String filePath = "test.txt";
        FileDetector result = new FileDetector();
        FileFormat format = result.checkFileFormat(filePath);
        assertFalse(format instanceof JsonFileFormat);
        assertFalse(format instanceof XmlFileFormat);
        assertFalse(format instanceof CsvFileFormat);
        assertNull(format);
    }




}
