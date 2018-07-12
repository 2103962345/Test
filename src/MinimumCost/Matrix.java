package MinimumCost;
import java.util.Arrays;

public class Matrix {
	// The limit of the cost
	final int INF = 99999;
	// Declaration of array that contains the transportation cost 
	private int[][] cost;
    
	//Constructor with parameters for determine of matrix size 
	public Matrix (int size) {
		cost = new int [size][size];
	}
	
	// Get the transportation cost between two cities
	public int getCost (int i, int j) {
		if (i == j) {
			return 0;
	    }
		 // If the cities is not connected to each other than return limit of the cost.
		if (cost [i][j] == 0){
			return INF;
		}
	    return cost [i][j];
	}
	    
	// Return the index of the shortest path
	private int findShortPath (int[] result, boolean [] visited) {
		int cheap = 0;
	    for (int i = 0; i < cost.length; i++) {
	    	/*
	    	 *  The city was not visited and the path [i]
	    	 *  less than the path[cheap], change the cost.
	    	 */
	    	if (!visited[i] && (result[i] < result[cheap])) {
	    		cheap = i;
	        }
	    }
	    return cheap;
	}

	// Return an array of the direct connections from the fromCity to other cities
	public int[] findDirectConnections (int source) {
		
		// Declare and initialize the array 
		int[] result = new int[cost.length];
		// Set tops mark
		Arrays.fill(result, INF);
		// Assign first top mark equal to "source", because this city is the starting point
		result [source] = source;
		// Information about visited cities
		boolean []visited = new boolean [cost.length];
		
		// Iterate all cities
		for (int i = 0; i < cost.length; i++){
			// Select the city which has a minimum mark
			int city = findShortPath(result, visited);
			// Mark city as visited
	        visited [city] = true;
	        
	     // Find the minimum path between cities
	        for (int j = 0; j < cost.length; j++){
	        	result [j] = Math.min(result[j], result[city] + getCost(city,j));
	        }
		}
		return result;
	}
   
	// Set the cost of the connection between neighbors
	public void setCost(int i, int j, int tcost) {
		cost[i][j] = tcost;
    }
}