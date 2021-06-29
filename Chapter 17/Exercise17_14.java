import java.io.*;
import java.util.Scanner;

/*(Encrypt files) Encode the file by adding 5 to every byte in the file. 
 * Write a program that prompts the user to enter an input file name and 
 * an output file name and saves the encrypted version of the input file 
 * to the output file.
 */
public class Exercise17_14 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String inputFileName = scanner.next();
		System.out.print("Enter an output file name: ");
		String outputFileName = scanner.next();

		try (
			FileOutputStream output = 
				new FileOutputStream(outputFileName);
				){
			for (int i = 1; i <= 10; i++) {
				output.write(5);
			}
		}
				
		try(
			FileInputStream input = 
				new FileInputStream(inputFileName);
				){	
			int value;
			while ((value = input.read()) != -1) {
				System.out.print(value + " ");
			}
			
		}
		
	}

}