package QuizesOld;

public class Chess8Queens {

	public static int[][] fillTable(int n) {
		int[][] out = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				out[i][j] = 0;
			}
		}
		return out;
	}
	
	public static void printTable(int[][] in) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length; j++) {
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] putFig(int[][] t, int x, int y) {
		for (int i = 0; i < t.length; i++) {
			t[x][i] = 1;
		}
		for (int j = 0; j < t.length; j++) {
			t[j][y] = 1;
		}
		int c = 0;
		while( (x+c) < t.length && (y+c) < t.length) {
			t[x+c][y+c] = 1;
			c++;
		}
		
		c = 0;
		while( (x-c) >= 0 && (y-c) >= 0) {
			t[x-c][y-c] = 1;
			c++;
		}
		
		c = 0;
		while( (x+c) < t.length && (y-c) >= 0) {
			t[x+c][y-c] = 1;
			c++;
		}
		
		c = 0;
		while( (x-c) >= 0 && (y+c) < t.length) {
			t[x-c][y+c] = 1;
			c++;
		}
		
		t[x][y] = 9;
		return t;
	}
	
	public static int[][] putNext(int[][] t, int x, int y) {
		if ( t[x][y] == 0 ) {putFig(t, x, y); return t;}
		else {System.out.println("FAIL"); return t;}
	}
	
	public  static int[][] tryToSolve (int[][] t, int x, int y, int d) {
		putNext(t,x,y);
//		printTable( t );
//		System.out.println("---------");
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if ( t[i][j] == 0) {
					t = putNext(t, i, j); 
//					System.out.println("--" + i + j +"--");
//					printTable( t );
				}
			}
		}
		return t;
	}
	
	public static boolean checkSolution (int[][] t, int d) {
		int c = 0;
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {	
				if (t[i][j] == 9) c++;
			}
		}
		return c == d;
	}
	
	
	public static void main(String[] args) {
		int d = 5;
		int c = 0;
		int[][] table;
		
		
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {			
				table = fillTable(d);
				table = tryToSolve (table,i,j, d);
				if (checkSolution(table, d) ) {
					System.out.println("--R--" + i + " " + j);
					printTable(table);
					c++;
				}
				
			}
		}
		System.out.println("Total solutions: " + c);

	}
}
