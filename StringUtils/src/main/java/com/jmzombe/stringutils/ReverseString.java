package com.jmzombe.stringutils;

public class ReverseString {

    public void reverseStringInPlace(String inputString) throws Exception {
     	System.out.println("\n===========================================");
        System.out.println("START: Reverse a String In Place");
        System.out.println("===========================================");
                       
        String[] ary = inputString.split("");
       
        String[] reversedStringArray = new String[inputString.length()];
        int j = inputString.length() - 1;
       	for (int i = 0; i <= inputString.length() - 1; i++) {
       	    reversedStringArray[i] =  ary[j];
       	    j--;
       	}
                                      
        StringBuilder builder = new StringBuilder();
        for (String s : reversedStringArray) {
            builder.append(s);
        }
        String reversedString = builder.toString();
        System.out.println("Reversed String Array: " + reversedString);
             
        System.out.println("===========================================");
        System.out.println("DONE: Reverse a String");
        System.out.println("===========================================\n");
        
        
        
        System.out.println("\n===========================================");
        System.out.println("START: Reverse a String in Place");
        System.out.println("===========================================");
        int i = 0;
        int k = inputString.length() - 1;
        while (i < k) {
        	String t = ary[i];
        	ary[i] = ary[k];
        	ary[k] = t;
        	i++;
        	k--;
        }
        for (int ctr = 0; ctr <= inputString.length() - 1; ctr++) {
            System.out.println("Reversed String Array[" + ctr + "]" + ary[ctr]);
        }
        System.out.println("===========================================");
        System.out.println("DONE: Reverse a String in Place");
        System.out.println("===========================================\n");
                      
    }
}
