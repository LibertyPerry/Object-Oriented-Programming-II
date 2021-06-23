import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_01 {
	public static void main(String[] args) throws IOException {
		double number = 0;
		try (
			FileOutputStream file = new FileOutputStream("Exercise17_01.txt");
		) {
			for (int x = 0; x < 100; x++) {
				number = (Math.random() * 100) + 1 ;
				file.write((int) number);
			}
		try (
			FileInputStream input = new FileInputStream("Exercise17_01.txt");
		){
			int value;
			while ((value = input.read()) != -1) {
				System.out.print(value + " ");
			}
		}
		}	
	}
}
