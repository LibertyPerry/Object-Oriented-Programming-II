/*
Author: Liberty Perry
Date: July 07 2021

Description: 
 */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
	  ArrayList<Integer> noDuplicates = new ArrayList<>();
	  for (int x = 0; x < list.size(); x++) {
		  if (noDuplicates.contains(list.get(x))) {
			  
		  }else {
			  noDuplicates.add((Integer) list.get(x));
		  }
	  }
	return (ArrayList<E>) noDuplicates;
  }
}
