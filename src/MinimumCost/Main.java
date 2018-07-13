package MinimumCost;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	//Read the information from the file and split it on array of strings
	public static String[] lineToString(String str) {
		return str.split(" ");
	}
	
	//Read the information from the file and parse it to int
	public static int lineToInt(String str) {
		return Integer.parseInt(str);
	}
	public static void findMinCost(String pathOfFile) throws IOException {
		
		// Open the file with information
	    BufferedReader br = new BufferedReader(new FileReader(pathOfFile));
	    int numberOfTests = lineToInt(br.readLine());
	    
	    for (int test = 0; test < numberOfTests; test++) {
	    	
	    	// Create a list of cities
	    	ArrayList<String> cities = new ArrayList<String>();
	    	//Get the number of cities
	        int numberOfCities = lineToInt(br.readLine());
	        
	        /* Create a matrix, of matrixSize
	         * The index of the first city must be 1
	         */
	        Matrix matrix = new Matrix (numberOfCities+1);
	        
	        for (int city = 0; city < numberOfCities; city++) {
	       //Get the name of city
	        String cityName = br.readLine();
	        //Add the name of city to list
	        cities.add(cityName);      
	        //Get the number of neighbors
	        int numberOfNeighbors = lineToInt(br.readLine());
	        // Iterate all neighbors
	        for (int neighbor = 0; neighbor < numberOfNeighbors; neighbor++){
	        	//Get the line and split it on the index of connected city and transportation cost
	            String [] cityCost = lineToString(br.readLine());
	            int connectedCity = Integer.parseInt(cityCost[0]);
	            int transportationCost = Integer.parseInt(cityCost[1]);
	            //Set the information to matrix of costs
	            matrix.setCost(city, connectedCity, transportationCost);
	            }    
	        }
	            
	      //Get the number of paths
	        int numberOfPaths = lineToInt(br.readLine());
	        // Iterate all paths
	        for (int path = 0; path < numberOfPaths; path++){
	        	 //Get the line and split it on fromCity and toCity names
	            String [] cityNames =  lineToString(br.readLine());
	            String fromCity = cityNames[0];
	            String toCity = cityNames[1];
	            //Set the index of cities
	            int fromCityIndex = cities.indexOf(fromCity);
	            int toCityIndex = cities.indexOf(toCity);
	            
	            // Find an array of the direct connections from the fromCity to other cities
	            int[] connections = matrix.findDirectConnections(fromCityIndex);
	            // Print the minimum transportation cost from fromCity to toCity
	        
	         System.out.println(connections[toCityIndex]);
	        }

	    }
	    // Close the stream
	    br.close();
	}
	
	public static void main (String[] args) throws IOException {
		findMinCost("src\\Input.txt");
	}
}
