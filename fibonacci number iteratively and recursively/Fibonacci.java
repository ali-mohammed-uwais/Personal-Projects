package fibonacci;

public class Fibonacci {

	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed recursively
	 */
	public static int recursive(int n) {
		   if(n == 0) {
			return 0; }
		   else if(n == 1) {
			return 1; 
		   }
		   else {
			   return recursive(n-1) + recursive(n-2);
			   
		   }
		
	}

	/**
	 * Below write your solution to Fibonacci, using iteration
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed iteratively
	 */
	public static int iterative(int n) {
        
        int current = 0;
        int x = 1;  

		for(int i = 0; i < n; i++) {
			int value = current;
			current = current + x;
			x = value;
			
			
		}
		
		return current;

		
		}
        	 
        	  
          	
			
		
	}


