import java.util.Scanner;

public class Exercise18_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Two Intergers: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		System.out.println("The greatest common divisor of " + m +" and " + n + " is: " + gcd(m, n));
		
	}
	public static int gcd(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return gcd(n, m % n);
		}
	}

}
