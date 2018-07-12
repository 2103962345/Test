package Brackets;

import java.util.Scanner;

public class Brackets {

	//Catalan number - recursion function that will calculate  the number of brackets
	 public static long catallan (long n) {
		 //array stores the number of brackets
		 long [] C = new long [(int) (n+1)];
		  C[0]=1; 
		  //Calculate C[m] for m=1..n
		  for (int m=1; m<=n; ++m)   
		  { 
		    C[m]=0; 
		    for (int k=0; k<m; ++k) 
		      C[m]+=C[k]*C[m-1-k]; 
		  } 
		//The resulting number is the answer
		  return C[(int) n]; 
		  }
	     
	 /*
		 * Get the number of matching brackets from the user.
		 * Save a reference to the information.
		 */
	  public static void show() {
	        	try (Scanner sc = new Scanner(System.in)) {
	        		while(true) {
	    			System.out.println("Enter number of brackets");
	    			/*
	            	 * Convert String with the information to long.
	            	 * If the resulting number is larger than 0,
	            	 * call the method, passing the resulting number as a parameter.
	            	 * If the value is less or equal to 0, print a message in the console.
	            	 */
	    			if (sc.hasNextInt()) {
	    				long number = Long.parseLong(sc.next());
	    				if (number >= 0) {
	    					System.out.println("The number of right bracket expression is " + catallan(number));
	    					break;
	    				} else {
	    					System.err.println("Enter positive integer number");
	    				}
	    			} else {
	    				System.err.println("Enter positive integer number ");
	    			}
	    			/*
		        	 * Catch exceptions.
		        	 * If conversion is impossible, print a message in the console. 
		        	 */
	        		}
	        		}catch(Exception e) {
	    	System.err.println("Error input");
	    }
	    }
	        
	public static void main(String[] args) {
		show();
			}
}
