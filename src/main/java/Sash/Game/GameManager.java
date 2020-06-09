package Sash.Game;

import java.util.Arrays;
import java.util.Scanner;

public class GameManager {
	Board gameBoard;
	Scanner input = new Scanner(System.in);
	int[][] winState = new int[][] {{1,2,3},{8,0,4},{7,6,5}};
	
	public GameManager() {
		gameSetup();
	}
	
	/*--------------------------------------------------------
	 * Core Game setup
	 * 	-Sets up Game Board based on selected difficulty
	 *	-Sets up Solution Type (self of specific Algorithm)
	 --------------------------------------------------------*/
	public void gameSetup() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("Hello and Welcome to the EightPuzzle");
		System.out.println("――――――――――――――――――――――――――――――――――――――――――");
		
		//select gameBoard difficulty
		gameBoard = difficultySelection();
		
		System.out.println("――――――――――――――――――――――――――――――――――――――――――");
		
		//selecting the method of playing the game you would like
		int	methodOfPlay = solverSetup();
		switch (methodOfPlay) {
			case 1: case 2: case 3: case 4: case 5: case 6:
				//TODO: Call AI with the number
				System.out.println("Case 1-6");
				break;
			case 7:
				humanPlay();
				break;
		}
	}
	
	/*--------------------------------------------------------
	 * Select and create the specific board state pertaining to the puzzle
	 --------------------------------------------------------*/
	public Board difficultySelection() {
		int difficulty;
		do {
			System.out.println("What Difficulty would you like?\n"
				+ "[1]\t Easy\n"
				+ "[2]\t Medium\n"
				+ "[3]\t Hard");
			difficulty = input.nextInt();
		} while (difficulty != 1 && difficulty != 2 && difficulty != 3);
		return new Board(difficulty);
	}
	
	/*--------------------------------------------------------
	 * Setup for the solving method 
	 * (Play on your own or have a specific algo solve the puzzle)
	 --------------------------------------------------------*/
	public int solverSetup() {
		boolean valid;
		int solutionType;
		do {
			System.out.println(
					"How would you like to solve the puzzle? (Input your choice's number)\n"
					+ "[1]\t Breadth-First Search\n"
					+ "[2]\t Depth-First Search\n"
					+ "[3]\t Uniform-Cost Search\n"
					+ "[4]\t Best-First Search (h= #of tiles in wrong pos)\n"
					+ "[5]\t A*1 (h= #of tiles in wrong pos)\n"
					+ "[6]\t A*2 (h= #sum of manhattan distances of all tiles)\n"
					+ "[7]\t Solve On Your Own");
			solutionType = input.nextInt();
			valid = solutionType < 8 && solutionType > 0 ? true : false;
		} while (!valid);
		return solutionType;
	}
	
	
	/*--------------------------------------------------------
	 * The method that handles the player making moves
	 --------------------------------------------------------*/
	public void humanPlay() {
		int dir;
		do {
			printCurBoardState();
			System.out.println("Please input the movement you want to make\n"
					+ "[1]\t Up\n"
					+ "[2]\t Down\n"
					+ "[3]\t Left\n"
					+ "[4]\t Right\n");
			dir = input.nextInt();

			if (dir < 5 && dir > 0) {
				gameBoard.move(dir);
			}
		} while(!checkSol());
		printCurBoardState();
		showWin();
	}
	
	public void printCurBoardState() {
		System.out.println("――――――――――――――Current―State―――――――――――――――");
		System.out.println("――――――――――――――――――――――――――――――――――――――――――");
		gameBoard.printBoardState();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――");
	}
	
	public void showWin() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=Congrats You won!=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		input.close();
	}
	
	public boolean checkSol() {
		return Arrays.deepEquals(gameBoard.getState(), winState);
	}
}
