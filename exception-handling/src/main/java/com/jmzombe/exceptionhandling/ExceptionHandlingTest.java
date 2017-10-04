package com.jmzombe.exceptionhandling;

import org.apache.commons.lang3.BooleanUtils;

public class ExceptionHandlingTest {

  public static void main(String[] args) {
	  
	  // Validate Integer
	  String acquireIncrement = "5a";
	  try {
		  int i = Integer.parseInt(acquireIncrement);
	      System.out.println("continue 1" + i);
	  } catch (NumberFormatException e) {
		  System.out.println("Invalid value " + acquireIncrement + " specified for acquireIncrement parameter.");
	  }
	  System.out.println("continue 2" + 1);
	  
	  
	  // Validate Boolean
	  String refreshConnection = " ";
	  try {
		  boolean result = BooleanUtils.toBooleanObject(refreshConnection, "true", "false", "null");
		  System.out.println("continue 3" + result);
	  } catch (IllegalArgumentException e) {
		  System.out.println("Invalid value " + refreshConnection + " specified for refreshConnection parameter.");  
	  }
	  System.out.println("continue 4");
 	 
  }
}
