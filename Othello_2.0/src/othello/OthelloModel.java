package othello;

/*
 * File Name: OthelloViewController
 * Author: Khair Ahmed , 040946481
 * Course: CST8233 Lab Section: 313
 * Assignment: Assignment 2 part 1
 * Date: November 22 2020
 * Purpose:	Will create the GUI and perform all mouse clicks
 * Class List: OthelloViewController, Controller, OthelloModel, Othello, OthelloNetworkModalViewController
 * 
 */
/**
 *  Creates the Splash Screen
 * @author Khair Ahmed
 * @version 1.0
 * @see  java.swing 
 * @see java.awt
 */
public class OthelloModel {
	/**
	 * internal Board
	 */
	private int[][] board = new int[7][7];
/**
 * normal game test
 */
	public static final int NORMAL = 0;
	/**
	 * corner game test
	 */
	public static final int CORNER_TEST = 1;
	/**
	 * outer game test
	 */
	public static final int OUTER_TEST = 2;
	/**
	 * test capture game test
	 */
	public static final int TEST_CAPTURE = 3;
	/**
	 * test capture game test2
	 */
	public static final int TEST_CAPTURE2 = 4;
	/**
	 * empty field
	 */
	public static final int UNWINNABLE = 5;
	/**
	 * inner test game
	 */
	public static final int INNER_TEST = 6;
/**
 * empty space val
 */
	public static final int EMPTY = 0;
	/**
	 * blk space val
	 */
	public static final int BLACK = 1;
	/**
	 * white space val
	 */
	public static final int WHITE = 2;
/**
 * initialize game board to whatever mode user wants
 * @param mode any of the static definations
 */
	public void initialize(int mode) {
		switch (mode) {
		case CORNER_TEST:
			board = new int[][] { { 2, 0, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 0, 1, 0 }, { 2, 0, 0, 0, 0, 0, 0, 2 } };

			break;
		case OUTER_TEST:
			board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 2, 2, 2, 2, 2, 0 }, { 0, 2, 1, 1, 1, 1, 2, 0 },
					{ 0, 2, 1, 0, 0, 1, 2, 0 }, { 0, 2, 1, 0, 0, 1, 2, 0 }, { 0, 2, 1, 1, 1, 1, 2, 0 },
					{ 0, 2, 2, 2, 2, 2, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
			break;
		case INNER_TEST:
			board = new int[][] { { 2, 2, 2, 2, 2, 2, 2, 2 }, { 2, 0, 0, 0, 0, 0, 0, 2 }, { 2, 0, 2, 2, 2, 2, 0, 2 },
					{ 2, 0, 2, 1, 1, 2, 0, 2 }, { 2, 0, 2, 1, 1, 2, 0, 2 }, { 2, 0, 2, 2, 2, 2, 0, 2 },
					{ 2, 0, 0, 0, 0, 0, 0, 2 }, { 2, 2, 2, 2, 2, 2, 2, 2 } };
			break;
		case UNWINNABLE:
			board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
			break;
		case TEST_CAPTURE:
			board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1, 1, 1, 0 },
					{ 0, 1, 2, 2, 2, 1, 1, 0 }, { 0, 1, 2, 0, 2, 1, 1, 0 }, { 0, 1, 2, 2, 2, 1, 1, 0 },
					{ 0, 1, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
			break;

		case TEST_CAPTURE2:
			board = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 1, 2, 1, 1 },
					{ 1, 2, 2, 2, 2, 2, 1, 1 }, { 1, 2, 2, 0, 2, 2, 1, 1 }, { 1, 2, 2, 2, 2, 1, 1, 1 },
					{ 1, 2, 1, 2, 2, 2, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
			break;
		default:
			board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 2, 1, 0, 0, 0 }, { 0, 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

		}
	}
/**
 * return the value of positonb of the board
 * @param x locaiton
 * @param y location
 * @return board[x][y]
 */
	public int getBoard(int x, int y) {
		return board[x][y];
	}
/**
 * is valid method that check if the locaton selected is  valid move
 * @param x location
 * @param y location
 * @param player black or white
 * @return true if move is valid move
 * @return false if move is not a valid move
 */
	public boolean isValid(int x, int y, int player) {

		int tempX;
		int tempY;
		int current;
		boolean found;
		int opposing =2;
		if(player ==2) {
			opposing =1;
		}
		if (board[x][y] == 0) {
			/*
			 * for loop is used in order to handle which direction the value is checking  for
			 * NORTH SOUTH EAST WEST SOUTHEAST NORTHEAST SOUTHWEST NORTHWEST
			 */
			for (int i = -1; i <2; i++) {
				for (int j = -1; j < 2; j++) {
					//add displacement so we can check
					tempX = i + x;
					tempY = j + y;
					found = false;
					//Check for out of bound
					if (tempX < 0 || tempY < 0 || tempX > 7 || tempY > 7) {
						continue;
					}
					current = board[tempX][tempY];
					if ( current == 0 || current == player) {
						continue;
					}
					while (!found) {//check in that direction until match is found or opposite color or empty is found
						tempX += i;
						tempY += j;
						//Check for out of bound
						if (tempX < 0 || tempY < 0 || tempX > 7 || tempY > 7) {
							continue;
						}
						current = board[tempX][tempY];
						if (current == player) {// if match return true;
							return true;
							//If not match is found go to  next direction
						} else if (current == opposing || current == 0) {
							found = true;
						}
					}
				}
			}
		}
		return false;
	}
/**
 * will complete the move that the user request
 * @param x location
 * @param y location
 * @param player black or white
 * @return captured which is the number of pieces captured
 */
	public int move(int x, int y, int player) {
		int captured = 0;
		int tempX;
		int tempY;
		int current;
	
		boolean lineMatch = false;

		if (board[x][y] == 0) {
			/*
			 * for loop is used in order to handle which direction the value is checking  for
			 * NORTH SOUTH EAST WEST SOUTHEAST NORTHEAST SOUTHWEST NORTHWEST
			 */
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					//set offset so we can check which direction we will have to flip the pieces
					tempX = i + x; 
					tempY = j + y;
					//Check for out of bound

					if (tempX < 0 || tempY < 0 || tempX > 7 || tempY > 7) {
						continue;
					}
					current = board[tempX][tempY];
					if (current == -1 || current == 0 || current == player) {
						continue;
					} else {
						captured++;
					}
					/*
					 * keep going in that direction until the line matches 
					 * if the line does not match it will return to start of for loop and check a new direction
					 */
					while (!lineMatch) {
						tempX += i;
						tempY += j;
						//Check for out of bound

						if (tempX < 0 || tempY < 0 || tempX > 7 || tempY > 7) {
							continue;
						}
						
						current = board[tempX][tempY];
						//if current piece  is the player then we have found
						if (current == player) {
							tempX -= i;
							tempY -= j;
							lineMatch = true;
							//Check for out of bound

							if (tempX < 0 || tempY < 0 || tempX > 7 || tempY > 7) {
								continue;
							}
							current = board[tempX][tempY];
							// match found set chip to player and go to next line to set
							while (current != 0) { 
								board[tempX][tempY] = player;
								tempX -= i;
								tempY -= j;

								current = board[tempX][tempY];

							}
							//If the line doesnt match then we exit out of this loop and check next direction
						} else if (current != player) {

							lineMatch = true;
							captured = 0;
						} else {
							//Capture success
							captured++;
						}
					}
				}
			}
		}
		//move has placed a piece on every location we want except for the one you selected
		// set location to player as well
		if (captured > 0)
			board[x][y] = player;

		return captured;
	}
/**
 * check all availble moves that user may be able to preform and if even on exist we return true
 * @param player black or white
 * @return true if move exist
 * @return false if move doesnt exist
 */
	public boolean canMove(int player) {
		for (int i =0; i<8; i++) {
			for (int j =0; j<8; j++) {
				if(this.isValid(i, j, player))
					return true;
			}
		}
		return false;
	}
/**
 * returns the amount of chip the player has
 * @param player
 * @return chips number of chips player has
 */
	public int getChips(int player) {
		int chips = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.getBoard(i, j) == player)
					chips++;
			}
		}
		return chips;
	}
}