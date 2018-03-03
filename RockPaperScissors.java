/****************************************************************************
 *
 * Created by: Matthew lourenco
 * Created on: Feb 2018
 * This program allows the user to play a game of rock paper scissors
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class RockPaperScissors {
	
	private enum Choices {
		
		ROCK,
		PAPER,
		SCISSORS;
		
		private static String findWinner(Choices user, Choices computer) {
			//Finds the winner
			if(user==computer) {
				return "Tie!";
			} else if(user==ROCK && computer==SCISSORS) {
				return "You won!";
			} else if(user==PAPER && computer==ROCK) {
				return "You won!";
			} else if(user==SCISSORS && computer==PAPER) {
				return "You won!";
			} else {
				return "You lost.";
			}
		}
	}
	
	public static void main(String[] args) {
		//Gets the user's choice and determines who has won
		
		String userInput = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		Choices userChoice;
		
		//Get the user's choice
		while(true) {
			System.out.println("Choose \"rock,\" \"paper,\" or \"scissors\" "
					+ "by typing it on your keyboard: ");
			try {
				//Get user input
				userInput = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				userChoice = Choices.valueOf(userInput.toUpperCase());
				break;
			} catch (IllegalArgumentException nonValidOption) {
				System.out.println("Please choose \"rock,\" \"paper,\" or"
						+ " \"scissors\"");
			}
		}
		
		//Generate computer's choice
		Random rand = new Random();
		Choices computerChoice = Choices.values()[rand.nextInt(3)];
		
		//Print results
		System.out.println("Computer: "+computerChoice+"\nUser: "+userChoice);
		System.out.println(Choices.findWinner(userChoice, computerChoice));
	}
}