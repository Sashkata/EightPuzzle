package Sash.Game;

import java.util.Arrays;

public class Board {
	private int[][] state;
	private int emptyRowLoc;
	private int emptyColLoc;
	
	
	/*--------------------------------------------------------
	 * Creates the Board and sets the Empty Location ("0") 
	 * Difficulties:
	 * 1 - Easy
	 * 2 - Medium
	 * 3 - Difficult
	 ---------------------------------------------------------*/
	public Board(int difficulty) {
		if (difficulty == 1) {
			this.state = new int[][] {{1,3,4},{8,6,2},{7,0,5}};
			this.emptyRowLoc = 2;
			this.emptyColLoc = 1;
		} 
		
		else if (difficulty == 2) {
			this.state = new int[][] {{2,8,1},{0,4,3},{7,6,5}};
			this.emptyRowLoc = 1;
			this.emptyColLoc = 0;
		} 
		
		else {
			this.state = new int[][] {{5,6,7},{4,0,8},{3,2,1}};
			this.emptyRowLoc = 1;
			this.emptyColLoc = 1;
		}
	}
	
	
	/*-------------------------------------------------------
	 * Print the current board state in the following format:
	 * 						[x,x,x]
	 * 						[x,x,x]
	 * 						[x,x,x]
	 --------------------------------------------------------*/
	public void printBoardState() {
		for (int[] row : this.state){
			System.out.println(Arrays.toString(row));
		}
	}
	
	
	/*-------------------------------------------------------
	 * Swap the empty Location(0) and a neighbor
	 * Possible Moves:
	 *  UP(1) 
	 *  DOWN(2) 
	 *  LEFT(3) 
	 *  RIGHT(4)
	 --------------------------------------------------------*/
	public void move(int dir) {
		switch(dir) {
			case 1: //UP
				if (emptyRowLoc > 0) {
					int val = this.state[emptyRowLoc - 1][emptyColLoc];
					this.state[emptyRowLoc-1][emptyColLoc] = 0;
					this.state[emptyRowLoc][emptyColLoc] = val;
					this.setEmptyRowLoc(getEmptyRowLoc()-1);
				}
				break;
			case 2: //Down
				if (emptyRowLoc < 2) {
					int val = this.state[this.emptyRowLoc + 1][this.emptyColLoc];
					this.state[this.emptyRowLoc+1][this.emptyColLoc] = 0;
					this.state[this.emptyRowLoc][this.emptyColLoc] = val;
					this.setEmptyRowLoc(getEmptyRowLoc()+1);
				}
				break;
			case 3: //Left
				if (emptyColLoc > 0) {
					int val = this.state[this.emptyRowLoc][this.emptyColLoc -1];
					this.state[this.emptyRowLoc][this.emptyColLoc -1] = 0;
					this.state[this.emptyRowLoc][this.emptyColLoc] = val;
					this.setEmptyColLoc(getEmptyColLoc()-1);
				}
				break;
			case 4: //Right
				if (emptyColLoc < 2) {
					int val = this.state[this.emptyRowLoc][this.emptyColLoc +1];
					this.state[this.emptyRowLoc][this.emptyColLoc +1] = 0;
					this.state[this.emptyRowLoc][this.emptyColLoc] = val;
					this.setEmptyColLoc(getEmptyColLoc()+1);
				}
				break;
			default:
				System.out.println("WRONG INPUT!");
		}
	}
	

	/*
	 * Getters and Setters
	 */
	public int[][] getState() {
		return state;
	}
	public void setState(int[][] state) {
		this.state = state;
	}
	public int getEmptyRowLoc() {
		return emptyRowLoc;
	}
	public void setEmptyRowLoc(int emptyRowLoc) {
		this.emptyRowLoc = emptyRowLoc;
	}
	public int getEmptyColLoc() {
		return emptyColLoc;
	}
	public void setEmptyColLoc(int emptyColLoc) {
		this.emptyColLoc = emptyColLoc;
	}
	
	
}
