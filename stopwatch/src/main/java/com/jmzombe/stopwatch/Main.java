package com.jmzombe.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

public class Main {
  
	public static void main(String[] args) { 
	  StopWatch clock = new StopWatch();
		    
	  System.out.println("How long does it take to take the sin of 0.34 ten million times?");
	  clock.start();
	  for (int i = 0; i < 100000000; i++) {
	    Math.sin( 0.34 );
	  }
	  clock.stop();
      System.out.println( "It takes " + clock.getTime() + " milliseconds" );
   }
}