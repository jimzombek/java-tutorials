package com.jmzombe.lineparser;

public class TextParser {
	
	public TextParser() {
	}
	
	public String parseLine(String line) {
	  String book = new String();
	  
	  //String line = "Genesis 1:1	In the beginning God created the heaven and the earth.";
	  
	  String[] results1 = line.split(":");
	  
	  String[] results2 = results1[0].split(" ");
	  System.out.println("Book: " + results2[0]);
	  System.out.println("Chapter: " + results2[1]);
	  
	  String part2 = results1[1];
	  Integer verse = Integer.parseInt(part2.substring(0, 3).replace(" ", ""));
	  System.out.println("Verse: " + verse);
	  
	  
	  //String[] results3 = results1[1].    .split(" ");
	  
	  // converts string to int
	  //Integer.parseInt(s.replaceAll("[\\D]", ""))
	  
	 
	  
	  return book;
	}
}
