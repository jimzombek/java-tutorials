package com.jmzombe.lineparser;

public class Main {
	public static void main(String[] args) throws Exception {
     	System.out.println("\n===========================================");
        System.out.println("START: Line Parser");
        System.out.println("===========================================");
            
//        FileReader fileReader = new FileReader(itemValue);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringBuffer stringBuffer = new StringBuffer();
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            stringBuffer.append(line + "\n");
//            int[] value;
//
//        }
//        fileReader.close();
//        System.out.println("Contents of file:");
//        System.out.println(stringBuffer.toString());
        
                    
        String line = "Genesis 1:112	In the beginning God created the heaven and the earth.";
        
        TextParser parser = new TextParser();
        String book = parser.parseLine(line);
        //System.out.println("Book: " + book);
               
        System.out.println("\n===========================================");
        System.out.println("END: Line Parser");
        System.out.println("===========================================");
	}
}
