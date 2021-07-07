/*
Author: Liberty Perry
Date: July 07 2021

Description: (Sort ArrayList) Write the following method that sorts an ArrayList.
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	  E currentMin; 
	  int currentMinIndex;
	  for (int x = 0; x < list.size(); x ++) {
		  currentMin = list.get(x);
		  currentMinIndex = x;
		  for (int y = x + 1; y < list.size(); y++) {
			  if (currentMin.compareTo(list.get(y)) > 0) {
				  currentMin = list.get(y);
				  currentMinIndex = y;
			  }
		  }
		  if (currentMinIndex != 1) {
			  list.set(currentMinIndex, list.get(x));
			  list.set(x, currentMin);
		  }
	  }
  }
}
