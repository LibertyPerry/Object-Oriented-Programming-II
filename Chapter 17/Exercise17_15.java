import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String inputFileName = scanner.next();
		System.out.print("Enter an output file name: ");
		String outputFileName = scanner.next();
		
        try (BufferedInputStream in = 
        		new BufferedInputStream(new FileInputStream(inputFileName));
             BufferedOutputStream out = 
            		 new BufferedOutputStream(new FileOutputStream(outputFileName));
            		 ) {

            int buffer;
            while ((buffer = in.read()) != -1) {
                out.write(buffer - 5);
            }

            System.out.println("File Unencrypted!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}