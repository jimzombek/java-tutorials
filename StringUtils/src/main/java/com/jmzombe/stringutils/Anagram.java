package com.jmzombe.stringutils;

import java.util.Arrays;

public class Anagram {
    public Anagram() {
    }
    
    public void isAnagram(String inputString1, String inputString2) throws Exception {
     	System.out.println("\n===========================================");
        System.out.println("START: Is Anagram");
        System.out.println("===========================================\n");
        
        System.out.println("Input String1: " + inputString1);
        System.out.println("Input String2: " + inputString2);
        
        if (checkIfStringsAreAnagrams(inputString1, inputString2)) {
            System.out.println("Strings are anagrams");
        } else {
        	System.out.println("Strings are NOT anagrams");
        }
  
        System.out.println("\n===========================================");
        System.out.println("DONE: Is Anagram");
        System.out.println("===========================================\n");
    }
    
    private boolean checkIfStringsAreAnagrams(String input1, String input2) { 
      	boolean result = false;
      	
    	// Remove spaces from input strings and convert to lowercase
        String input1String = input1.replaceAll("\\s+", "").toLowerCase();
        String input2String = input2.replaceAll("\\s+", "").toLowerCase();
                        
        // If string lengths are the same, continue checking
        if (input1String.length() == input2String.length()) {
    	  char[] charFromInput1 = input1String.toCharArray(); 
    	  char[] charFromInput2 = input2String.toCharArray();
    	  
    	  // Sort input strings and compare for equality.
    	  Arrays.sort(charFromInput1); 
    	  Arrays.sort(charFromInput2); 
    	  result = Arrays.equals(charFromInput1, charFromInput2);
        };
        
        return result;
    }
}
