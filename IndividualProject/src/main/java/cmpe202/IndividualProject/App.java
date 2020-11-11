package cmpe202.IndividualProject;

public class App 
{
	public static void main( String[] args )
    {
		String inputFile = args[0];
		String outputFile = args[1];
		Processor processor = new Processor();
		processor.processCard(inputFile, outputFile);

    }
}
