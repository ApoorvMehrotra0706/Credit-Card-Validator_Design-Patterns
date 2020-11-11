package cmpe202.IndividualProject;

import java.util.Scanner;

public class App 
{
	public static void main( String[] args )
    {
		Scanner sc = new Scanner(System.in);
		String inputFile = args[0];
		String outputFile = args[1];
		Processor processor = new Processor();
		processor.processCard(inputFile, outputFile);

    }
}
