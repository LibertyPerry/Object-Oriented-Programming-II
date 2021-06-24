/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        try (
        		ObjectOutputStream output = 
        		new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
    	try (
        		ObjectInputStream input = 
        		new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        ){
          
           while (true) {
        	   Loan loan = (Loan)input.readObject();
        	   System.out.printf("Total loan amountl: $%.2f\n", loan.getTotalPayment());
        	   System.out.println();
           }
    	}
    	catch (EOFException ex) {
    		
    	}
    }
}
