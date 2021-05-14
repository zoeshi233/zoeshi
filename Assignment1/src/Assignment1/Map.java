
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Shuyi Shi
Student Number: 216816555
Course Section: B
*/

package Assignment1;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	private boolean isCaught;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row = row;
		this.column = column;
		map = new boolean[row][column];
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(0 > startRow || startRow > this.row || 0 > startCol ||
				startCol > this.column || 0 > destRow || destRow > this.row || 
				0 > destCol || destCol > this.column){//Exception is returned if any one of startRow/Column or destRow/Column is not inside the range of [0, Row/Column given]
			throw new IllegalArgumentException("Not in range");
		}
		if(startRow >= destRow && startCol >= destCol) {//Pre-condition of decide which direction method to go
			return goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		if(startRow >= destRow && startCol <= destCol) {
			return goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		if(startRow <= destRow && startCol <= destCol) {
			return goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		if(startRow <= destRow && startCol >= destCol) {
			return goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		return path;
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow > destRow) {//when startRow > destRow means current point is above the destination point, which means need to go south
			startRow--;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		if(startCol > destCol) {
			startCol--;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		return path;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow > destRow) {
			startRow--;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		if(startCol < destCol) {
			startCol++;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		return path;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow < destRow) {
			startRow++;
			if(map[startRow][startCol]) {//when the current coordinate have been used
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		if(startCol < destCol) {
			startCol++;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		return path;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow < destRow) {
			startRow++;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		if(startCol > destCol) {
			startCol--;
			if(map[startRow][startCol]) {//if map array is true then the coordinate has been deployed and will be caught by police
				isCaught = true;
				return path;
			}
			path += " (" + startRow + "," + startCol + ")";
			map[startRow][startCol] = true;
			return goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		return path;
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	
	public String findPath (int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		Random random = new Random();
		isCaught = false;
		int gameStartRow = startRow;
		int gameStartCol = startCol;
		int gameNextRow = startRow;
		int gameNextCol = startCol;
		String path = "(" + startRow + "," + startCol +  ")";
		while(!isCaught && !onBorder(gameNextRow, gameNextCol)){
			gameNextRow = random.nextInt(2) - 1 + gameStartRow;//it generates a random direction of next row, north, stay or south
			gameNextCol = random.nextInt(2) - 1 + gameStartCol;//it generates a random direction of next column, west, stay or east
			path = getPath(gameStartRow, gameStartCol, gameNextRow, gameNextCol, path);//use the direction methods to build the string path
			gameStartRow = gameNextRow;//save the previous row number before assign a new random number
			gameStartCol = gameNextCol;//save the previous column number before assign a new random number
		}
		if(!isCaught) {
			return path;
		}
			clearMap();//reset the map
			return findPath(startRow, startCol);//start over if have been caught
	}
	
	private boolean onBorder(int currentRow, int currentCol) {
		return currentRow == 0 || currentCol == 0 || currentRow == this.row - 1 || currentCol == this.column - 1;
	}
	
	private void clearMap(){
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				map[i][j] = false;
			}
		}
	}
} // end of class
