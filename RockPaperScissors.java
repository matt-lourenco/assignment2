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
	
	private static String findWinner(String user, String computer) {
		//Finds the winner
		if(user.equals(computer)) {
			return "Tie!";
		} else if(user.equals("rock") && computer.equals("scissors")) {
			return "You won!";
		} else if(user.equals("paper") && computer.equals("rock")) {
			return "You won!";
		} else if(user.equals("scissors") && computer.equals("paper")) {
			return "You won!";
		} else {
			return "You lost.";
		}
	}
	
	public static void main(String[] args0 ) {
		//Gets the user's choice and determines who has won
		
		String[] choiceIndex = {"rock", "paper", "scissors"};
		String userInput = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		
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
			//check if input is in choiceIndex
			userInput = userInput.toLowerCase();
			boolean validChoice = false;
			for(String item: choiceIndex) {
				if(item.equals(userInput)) {
					validChoice = true;
					break;
				}
			}
			if(!validChoice) {
				System.out.println("Please choose \"rock,\" \"paper,\" or"
						+ " \"scissors\"");
			} else {
				break;
			}
		}
		
		//Generate computer's choice
		Random rand = new Random();
		String computerChoice = choiceIndex[rand.nextInt(3)];
		
		//Print results
		System.out.println("Computer: "+computerChoice+"\nUser: "+userInput);
		System.out.println(findWinner(userInput, computerChoice));
	}
}