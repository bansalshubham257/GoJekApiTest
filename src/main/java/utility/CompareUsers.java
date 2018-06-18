package main.java.utility;

import main.java.utility.Comparator;


public class CompareUsers implements Comparator<String> {
	 
	 public boolean compare(String obj1, String obj2)
     {
	        	return obj1.equals(obj2);
     }
	 
 }
	 
