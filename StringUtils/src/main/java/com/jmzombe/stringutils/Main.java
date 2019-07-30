package com.jmzombe.stringutils;

public class Main {
	public static void main(String[] args) throws Exception {
     	System.out.println("\n===========================================");
        System.out.println("START: Test String Utils");
        System.out.println("===========================================");
                
        DuplicateChars dupChars = new DuplicateChars();
        dupChars.detectDupChars("11233455677899");
        
        ReverseString reverseString = new ReverseString();
        reverseString.reverseStringInPlace("11233455677899");
        
        Anagram anagram = new Anagram();
        anagram.isAnagram("Astronomer", "Moon starer");
        anagram.isAnagram("Astronomer", "jimz");
        
        System.out.println("\n===========================================");
        System.out.println("END: Test String Utils");
        System.out.println("===========================================");
	}
}
