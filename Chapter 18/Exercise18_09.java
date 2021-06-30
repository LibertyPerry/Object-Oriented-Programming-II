import java.util.Scanner;

public class Exercise18_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String to reverse: ");
		String string = scanner.nextLine();
		System.out.println("String reversed: ");
		reverseDisplay(string);
	}
	public static void reverseDisplay(String value) {
		if (value.length() == 1) {
			System.out.print(value);
		} else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}

}
