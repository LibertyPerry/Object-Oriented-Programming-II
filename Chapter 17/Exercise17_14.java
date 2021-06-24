import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			ObjectOutputStream output = 
				new ObjectOutputStream(new FileOutputStream(outputFileName));
				){
			for (int i = 0; i < 100; i++) {
				if ( i % 5 == 0) {
					output.writeInt(5);
				}
			}
			
		}
		try (
			ObjectInputStream input = 
				new ObjectInputStream(new FileInputStream(inputFileName));
				){
		}
		
	}

}
