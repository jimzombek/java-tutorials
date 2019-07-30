package com.jmzombe.stringutils;

import java.util.HashMap;
import java.util.Map.Entry;

public class DuplicateChars {
    public DuplicateChars() {
    }
    
    public void detectDupChars(String inputString) throws Exception {
     	System.out.println("\n===========================================");
        System.out.println("START: Detect Dup Characters in String");
        System.out.println("===========================================");
        
        System.out.println("Input String: " + inputString);
        
        HashMap<String, Integer> dupMap = new HashMap<String, Integer>();
        
        String[] ary = inputString.split("");
        for (int i = 0; i <= inputString.length() - 1; i++) {
       	    if (dupMap.containsKey(ary[i])) {
       	    	dupMap.put(ary[i], dupMap.get(ary[i]) + 1);
       	    } else {
       	    	dupMap.put(ary[i], 1);
       	    }
       	}
                       
        for (Entry<String, Integer> entry : dupMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }
        }
                           
        System.out.println("===========================================");
        System.out.println("DONE: Detect Dup Characters in String\n");
        System.out.println("===========================================\n");
    }
}
