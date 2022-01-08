package assignment6;

public class RecursiveMethods {

	/**
	 * Recursively computes base ^ exponent
	 * 
	 * @param base the base - can be positive or negative
	 * @param exp  the exponent - can be positive or negative
	 * @return base ^ exponent
	 */
//	public static double exponent1(int base, int exp) {
		
			// FIXME Recursively compute base^exp
		
	
	public static double exponent(int base, int exp) {
		if(exp == 0 || (exp == 0 && base == 0)) {
			return 1;
			}
	 if(exp <= 0) {
		 
		 return 1/(base * exponent(base, (-1*exp)-1));
		 
	 }
	 else {
		 return base * exponent(base, exp -1);
		 
	 }  
	   
	   
		
}
	
	public static int arraySum(int[] array) {
		  int rightIndex = array.length - 1;
		  int sum = 0;
		   return arraySumHelper(array, rightIndex, sum);
			
		  
	}
	/**
	 * 
	 * @param array 
	 * @param rightIndex -- > we want to keep track of each index so we keep on adding
	 * @param sum is a variable that would keep on collecting the value for the variable
	 * @return actual sum 
	 */
	
	public static int arraySumHelper(int[] array, int rightIndex, int sum) {
	      if(rightIndex < 0) {
	    	  return sum;
	      }
	      else{
	    	  sum = sum + array[rightIndex];
	    	 return arraySumHelper(array, rightIndex - 1, sum);
	      
	      }
		
	
	}

	/**
	 * Return a new String which is the original source String with all occurrences
	 * of the target character substituted by the replacement String.
	 * 
	 * @param source      the source String
	 * @param target      the target character to be replaced
	 * @param replacement the replacement String
	 * 
	 * @return the String which results from substituting all of the target
	 *         characters in the source String with the replacement String
	 */
	/**
	 
	 * 
	 * 
	 * 
	 * 
	
	
	String result = "";
		for (int i = 0; i < source.length(); ++i) {
			char ch = source.charAt(i);   //breaking string as an array. 
			if (ch == target) {
				result = result + replacement;
			} else {
				result = result + ch;
			}
		}
		return result;
	 * 
	 * 
	*/
	
	public static String substituteAll(String source, char target, String replacement) {
	 
		
		
		String result = "";
		int leftIndex = 0;

		
	   return substituteAllHelper(source, target, replacement, result, leftIndex);
		
		
		
		
	}
	
	public static String substituteAllHelper(String source, char target, String replacement, String result, int leftIndex) {
		if(leftIndex == source.length()) {
			return result;
		}
		else {
			char ch = source.charAt(leftIndex);
			if(ch == target) {
				result = result + replacement;
				return substituteAllHelper(source, target, replacement, result, leftIndex + 1);
			}
			else {
				result = result + ch; 
				return substituteAllHelper(source, target, replacement, result, leftIndex + 1);
			}
		}
	}


	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */
	public static String dragon(int n) {
		  String result = "";
	
		  if(n == 0) {
		  return "F-H";     
				  } 
		  
		  else {
			
			String r = substituteAll(dragon(n-1), 'F', "v");   //the v is like a placehold, especially when we make different variables equal to each other
			String x = substituteAll(r, 'H', "F+H");
			String y = substituteAll(x, 'v', "F-H" );
			 
			
			
			  
			  
			  return y;
			  
			  
			  
		  }
				
			
	}
	
	
//	public static String dragonHelper(String origin, int n, int currentDegree, String result, int leftIndex) {
//		if(currentDegree > n) {
//			return origin;
//		}
//
//		else {
//			char ch = origin.charAt(leftIndex);
//		     if(leftIndex == origin.length()) {
//				origin = result;
//				result = "";
//				leftIndex = 0;
//				
//				return dragonHelper(origin, n, currentDegree + 1, result, leftIndex);
//
//				}
//			else if(ch == 'F') {
//				
//				return dragonHelper(origin, n, currentDegree, result, leftIndex + 1);
//			}
//			else if(ch == 'H') {
//				result = result + "F+H";
//				return dragonHelper(origin, n, currentDegree, result, leftIndex + 1);
//			}
//			
//			else {
//				result = result + ch; 
//				return dragonHelper(origin, n, currentDegree, result, leftIndex + 1);
//			}
//		}
//		
//		
//}
//	

	
	

	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * code assuming you have already done things already correctly
	 * 2 base cases: think about your starting at the end.
	 * is the spot no good? is the spot outside/does not exist on the diagram
	 * big important check is the recursion: if the spot your checking is true--> if u know its a good path
	 * of the four different branches, array.sot we only want maximum of the four different paths. 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */
	public static int maxPathLength(boolean[][] chart, int r, int c) {
		   
		if(((r < 0 || r > chart.length-1)) || (c < 0 || c > chart[r].length-1)) {
			return 0;
		}
		
		else if(!chart[r][c]) {
			return 0;
		}
		
		
		
		else {
			chart[r][c] = false; 
			int up = maxPathLength(chart, r-1, c);
			int down = maxPathLength(chart, r+1, c);
			int left =  maxPathLength(chart, r, c-1);
			int right = maxPathLength(chart, r, c+1);
			chart[r][c] = true; 

			return Math.max(Math.max(left, right), Math.max(up, down)) + 1;
		}
		
		                   //starting off with the 4 messengers			
	}
}
