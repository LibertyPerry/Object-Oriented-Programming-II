import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		double number = 0;
		try (
			DataOutputStream file = 
				new DataOutputStream(new FileOutputStream("Exercise17_03.dat"));
		) {
			for (int x = 0; x < 100; x++) {
				number = (Math.random() * 100) + 1 ;
				file.writeInt((int) number);
			
			}
		try (
			DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat"));
		){
			int value;
			double sum = 0;
			while ((value = input.read()) != -1) {
				sum += value;
				}
			System.out.println(sum);
		}
		}	
	}
}
