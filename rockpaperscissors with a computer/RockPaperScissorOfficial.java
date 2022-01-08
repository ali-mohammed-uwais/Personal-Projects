package rockpaperscissors;

import support.cse131.ArgsProcessor;
import java.lang.Math;

public class RockPaperScissorOfficial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor(args);

		int rock = 0;
		int papers = 1;
		int scissors = 2;
		int playerWins = 0; 
		int playerLosses = 0;
		int computerWins = 0;
		int ComputerLosses = 0;
		int games = ap.nextInt("Please enter how many times you would like to play Rock, Paper, Scissors?");
	    

		int playerDecision = ap.nextInt("Hi! Please enter 0 for rock, 1 for papers, or 2 for scissors");
	        while(playerDecision > 2 || playerDecision < 0) {
		      playerDecision = ap.nextInt("Hi! Please enter 0 for rock, 1 for papers, or 2 for scissors");}
	     
	     
		for(int i = 0; i < games; i++) { //number of times the games will run. The game will stop once we know
		     
			boolean someoneWon = false; //automatically turns someoneWon to false after each iteration
		    int computerDecision = (int) (Math.random() * 3); //gives me 0, 1, 2 so it would represent rock, papers and scissors
 
		     while(someoneWon == false) {
		     
		     if(playerDecision == rock && computerDecision == scissors) {
		    	 playerWins++;
		    	 ComputerLosses++;
		    	 someoneWon = true;
		     }
		     else if(playerDecision == computerDecision) {
		    	 if(playerDecision == 2) {
			    	 playerDecision = 0;
			     }
			     
			     else if(playerDecision == 0 || playerDecision == 1) {
			    	 playerDecision++;
			     }
				 computerDecision = (int) (Math.random() * 3); //gives me 0, 1, 2 so it would represent rock, papers and scissors

		     }
		     else if(playerDecision == 1 && computerDecision == 0 ) {
		    	 playerWins++;
		    	 ComputerLosses++;
		    	 someoneWon = true;
		     }
		     else if(playerDecision == 2 && computerDecision == 1) {
		    	 playerWins++ ;
		    	 ComputerLosses++ ;
		    	 someoneWon = true;
		     }
		     //now if the computer wins
		     else if(playerDecision == 2 && computerDecision == 0) {
		    	 computerWins++;
		    	 playerLosses++;
		    	 someoneWon = true;
		     }
		     else if(playerDecision == 0 && computerDecision == 1 ) {
		    	 computerWins++;
		    	 playerLosses++;
		    	 someoneWon = true;
		     }
		     else if(playerDecision == 1 && computerDecision == 2) {
		    	 computerWins++;
		    	 playerLosses++;
		    	 someoneWon = true;
		     } 
		     }
		    
		     if(playerDecision == scissors) {
		    	 playerDecision = rock;
		     }
		     
		     else if(playerDecision == rock || playerDecision == papers) {
		    	 playerDecision++;
		     }
		    
		     
		}
		
		
		System.out.println("Human player cycle won : " + playerWins + "/" + games + " of the games. Computer Play has won: " + computerWins + "/" + games + " of the games.");
		
		if(playerWins > computerWins) {
			System.out.println("Human Player has won!"); 
		}
		else if(computerWins > playerWins){
			System.out.println("Computer player has won!");
		}
		else if(computerWins == playerWins) {
			System.out.println("It is a tie!!");
			
			
		}
		
	}
		
		
		
		
}



	


