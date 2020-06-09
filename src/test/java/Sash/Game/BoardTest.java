package Sash.Game;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	/*****************************************************
	 * Board Creation and configuration Tests
	******************************************************/
	@Test
	void boardTest() {
		Board boardObj = new Board(1);
		assertNotNull(boardObj);
	}
	
	//Test to make sure Easy setup is in the correct starting configuration
	@Test
	void startStateEasyTest() {
		Board boardObj = new Board(1);
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{1,3,4},{8,6,2},{7,0,5}}));
	}
	
	//Test to make sure Medium setup is in the correct starting configuration
	@Test
	void startStateMedTest() {
		Board boardObj = new Board(2);
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{2,8,1},{0,4,3},{7,6,5}}));
	}
	
	//Test to make sure Hard setup is in the correct starting configuration
	@Test
	void stateStateHardTest() {
		Board boardObj = new Board(3);
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{5,6,7},{4,0,8},{3,2,1}}));
	}
	
	
	/*****************************************************
	 * Board Bounds Tests
	******************************************************/
	//Test to check top bound
	@Test
	void stateTopBoundsTest() {
		Board boardObj = new Board(2);
		boardObj.move(1);//bring 0 to Row 1
		boardObj.move(1);//Shouldn't do anything
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{0,8,1},{2,4,3},{7,6,5}}));
		
	}
	
	//Test to check left bound
	@Test
	void stateLeftBoundTest() {
		Board boardObj = new Board(3);
		boardObj.move(3);//move to first col
		boardObj.move(3);//stay in first col
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{5,6,7},{0,4,8},{3,2,1}}));
	}
	
	//Test to check right bound
	@Test
	void stateRightBoundTest() {
		Board boardObj = new Board(3);
		boardObj.move(4);//move to 3rd col
		boardObj.move(4);//stay in 3rd col
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{5,6,7},{4,8,0},{3,2,1}}));
	}
	
	//Test for bottom bound
	@Test
	void stateBotBoundsTest() {
		Board boardObj = new Board(2);
		boardObj.move(2);//bring 0 to Row 3
		boardObj.move(2);//Shouldn't do anything
		assertTrue(Arrays.deepEquals(boardObj.getState(), new int[][] {{2,8,1},{7,4,3},{0,6,5}}));
	}
}
