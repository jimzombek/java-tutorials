package com.jmzombe.charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class Main {
  
	public static void main(String[] args) { 
		String Str1 = new String("Welcome to JimZ.com");
	      try {
	    	 System.out.println("Default Charset = " + Charset.defaultCharset());
	    	 
	    	 SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
	    	 for (SortedMap.Entry<String, Charset> entry : availableCharsets.entrySet()) {
    		    System.out.println("Key Value " + entry.getKey());
    		    System.out.println("Value value " + entry.getValue());
	   		 }
	    	  
	         byte[] Str2 = Str1.getBytes();
	         System.out.println("Default charset returned value " + Str2);

	         Str2 = Str1.getBytes("UTF-8");
	         System.out.println("UTF-8 charset returned value " + Str2);
	         
	         Str2 = Str1.getBytes("UTF-16");
	         System.out.println("UTF-16 charset returned value " + Str2);

	         Str2 = Str1.getBytes("ISO-8859-1");
	         System.out.println("ISO-8859-1 charset returned value " + Str2);
	      } catch (UnsupportedEncodingException e) {
	         System.out.println("Unsupported character set");
	      }
	}
}
