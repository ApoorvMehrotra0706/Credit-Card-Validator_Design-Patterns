package cmpe202.IndividualProject;

import java.io.File;

public class FileFactory {
	
	private FileFormat file;
	
	public FileFormat checkFileFormat(String filePath) {
		String fileName = new File(filePath).getName();
		int index = fileName.lastIndexOf(".");
		String extn = fileName.substring(index+1);
		if(extn.compareToIgnoreCase("csv") == 0)
			file = new CsvFileFormat();
		else if(extn.compareToIgnoreCase("json") == 0)
			file = new JsonFileFormat();
		else if(extn.compareToIgnoreCase("xml") == 0)
			file = new XmlFileFormat();
		return file;
	}
}
