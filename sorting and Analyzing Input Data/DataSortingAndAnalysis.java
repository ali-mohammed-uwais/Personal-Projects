package sortanalysis;

import support.cse131.ArgsProcessor;

public class DataSortingAndAnalysis {
	public static void main(String[] args) {
	ArgsProcessor ap = new ArgsProcessor(args);
	
	
	int size = ap.nextInt("Please enter the size of the collection");
	while(size < 0) {
		size = ap.nextInt("Please enter the size of the collection");
	}
	int[] collectionArray = new int [size];
	int[] copyArray = new int [size];
	
	System.out.print("Input: ");
	for(int i = 0; i < size; i++) { //sorting the array
	int input = ap.nextInt("Please input numbers");	
	collectionArray[i] = input; 
	copyArray[i] = input;
	System.out.print(input + " ");
	}
	System.out.println();
	System.out.print("Sorted: ");
	
	for(int i = 0; i < size; i++) {
		for(int j = 1; j < size - i; j++) {
			if(copyArray[j-1] > copyArray[j]) {
				int bigValue = copyArray[j-1];
				copyArray[j-1] = copyArray[j];
				copyArray[j] = bigValue;
			}
			
		}
	}
	int sum = 0;
	double amount = size * 1.0;
	for(int i = 0; i < size; i++) {
	 System.out.print(copyArray[i] + " ");	
	 sum = sum + copyArray[i];
	}
	System.out.println();
	System.out.println("Mean: " + (sum/amount));
	int median = 0;
	if(amount % 2 == 1) {
		median  = (int)(amount/2.0 + 0.5);
		System.out.println("Median: " + (copyArray[median-1]*1.0));
		
	}
	else{
		int firstMiddle = (int)(amount/2);
		int secondMiddle = firstMiddle - 1;
		double medianEven = (copyArray[firstMiddle] + copyArray[secondMiddle])/2.0;
		System.out.println("Median: " + medianEven);
	}
	
	System.out.println("Min: " + copyArray[0]);
	System.out.println("Max: " + copyArray[size-1]);
	System.out.println("Range: " + (copyArray[size-1] - copyArray[0]));

	
	
	
	
	
	
		
	}
}
