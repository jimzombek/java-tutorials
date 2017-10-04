package com.jmzombe.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalApp 
{
    public static void main( String[] args ) {
        System.out.println( "Optional App Started!" );
                       	
       	try {
	        /* empty */
   		    Optional<?> emptyOptional = Optional.empty();
   		    System.out.println(emptyOptional.get());
 
       	} catch( NoSuchElementException ex ) {
	        System.out.println("expected NoSuchElementException" ); 
   		}
       	
       	String str = "JimZ";
       	Optional<String> nonEmptyOptional = Optional.of(str); 
        System.out.println(nonEmptyOptional.get());
        
        // If optionalCar is empty, will retrieve the price for the default car
        // that we have defined before.
        Integer defaultCar = 100;
        Optional<Integer> optionalCar = Optional.empty();
       	Integer price = optionalCar.orElse(defaultCar);
       	System.out.println("price of car: " + price);
         	
       	// There is the possiblity to check directly if the value is initialized and not null:
       	Optional<String> stringToUse = Optional.of("optional1 is there");
   		if (stringToUse.isPresent()) {
            System.out.println(stringToUse.get());
        }
   		
   		// And also the option to execute actions directly when the value is present, 
   		// in combination with Lambdas:
  		Optional<String> stringToUse2 = Optional.of("optional2 is there");
  		stringToUse2.ifPresent(System.out::println);
   			
   		// We can indicate the Optional to throw an exception in case its value is null:
       	String strNull = null;
       	Optional<String> nullableOptional = Optional.ofNullable(strNull);
       	nullableOptional.orElseThrow(IllegalStateException::new);
    }
}