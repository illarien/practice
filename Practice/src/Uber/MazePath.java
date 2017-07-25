package Uber;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Not mine, not sure that works.
 * Solve a maze", you have a 2D matrix with 1's as blocked  and 0's as path. 
 * Find a path from one corner to another, backtracking should be allowed.
 */

public class MazePath {

	  int x, y;
	  int[][] maze ={{0,1,1,1,1,1,1,1,1,1,1,1},
			  {0,0,0,0,1,0,0,0,0,0,0,1},
			  {0,0,1,0,1,0,1,1,1,1,0,1},
			  {0,1,1,0,1,0,0,0,0,1,0,1},
			  {0,0,0,0,0,1,1,1,0,1,0,1},
			  {0,1,1,1,0,1,0,1,0,1,0,1},
			  {0,0,0,1,0,1,0,1,0,1,0,1},
			  {0,1,0,1,0,1,0,1,0,1,0,1},
			  {0,0,0,0,0,0,0,0,0,0,0,1},
			  {0,1,1,1,1,1,0,1,1,1,0,1},
			  {0,0,0,0,0,0,0,1,0,0,0,1},
			  {0,0,0,0,0,0,0,0,0,0,0,0}};

	  public void solve() {
	    int[][] solution = new int[x][y];
	    if (solveMaze(solution, 0, 0)) {
	      System.out.println("Yes ");
	      for (int i = 0; i < x; i++) {
	        for (int j = 0; j < y; j++) {
	          System.out.print(solution[i][j] + " ");
	        }
	        System.out.println();
	      }
	    } else {
	      System.out.println("No Solution");
	      for (int i = 0; i < x; i++) {
	        for (int j = 0; j < y; j++) {
	          System.out.print(solution[i][j] + " ");
	        }
	        System.out.println();
	      }
	    }
	  }

	  private boolean solveMaze(int[][] solution, int x, int y) {
	    if (x == this.x - 1 && y == this.y - 1) {
	      solution[x][y] = 1;
	      return true;
	    }

	    if (isSafe(x, y)) {
	      solution[x][y] = 1;
	      if (solveMaze(solution, x, y + 1)) {
	        return true;
	      }
	      if (solveMaze(solution, x + 1, y)) {
	        return true;
	      }
	      solution[x][y] = 0;
	      return false;
	    }
	    return false;
	  }

	  private boolean isSafe(int x, int y) {
	    if (x < this.x && y < this.y && maze[x][y] == 1) {
	      return true;
	    }
	    return false;
	  }

	  public static void main(String[] args) {

//	    Scanner input = new Scanner(System.in);
	    MazePath mazePath = new MazePath();
//	    mazeProblem.x = input.nextInt();
//	    mazeProblem.y = input.nextInt();
	    mazePath.maze = new int[mazePath.x][mazePath.y];

//	    for (int i = 0; i < mazePath.x; i++) {
//	      for (int j = 0; j < mazePath.y; j++) {
//	    	  mazePath.problem[i][j] = input.nextInt();
//	      }
//	    }
	    mazePath.solve();
	  }
	}