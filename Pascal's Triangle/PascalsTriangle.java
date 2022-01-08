package pascal;

import support.cse131.ArgsProcessor;

public class PascalsTriangle {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int r = ap.nextInt("Please enter the number of rows");
		int c = ap.nextInt("Please enter the number of columns");
		int[][] array = new int[r][c];
		System.out.print("\t Column");
		System.out.println();
		System.out.print("\t");

		for(int i = 0; i < c; i++) {//printing out the numbers
			System.out.print(" " + i);  }
		System.out.println();
		System.out.println("row");
		System.out.println();


		for(int k = 0; k < r; k++) {
			System.out.print(k + "\t");  
			for(int j = 0; j < r; j++) { //rows
				for(int x = 0; x < c; x++) { //columns
					if(x == 0) {
						array[j][x] = 1; 
						System.out.print(array[j][x]);
					}
					else if(x==j) {
						array[j][x] = 1;
						System.out.print(array[j][x]);
					}
					else if((j < 0 || x < 0 )|| x > j) {
						
						System.out.print("  "); //double space as you do not show anything
					}
					else {
						if(x == 1) {
							System.out.print(j-1 + x + " ");
						}
						else{
							System.out.print((j-1) + (x-1) + " ");
						}
					}

				}
			}
			System.out.println();  //creates a new line for everything
		}


	}
}


