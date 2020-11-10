package cmpe202.IndividualProject;

import java.util.Scanner;

public class App 
{
	public static void main( String[] args )
    {
		Scanner sc = new Scanner(System.in);
		String inputFile = sc.nextLine(); 
		String outputFile = sc.nextLine();
		Processor processor = new Processor();
		processor.processCard(inputFile, outputFile);

    }
}
