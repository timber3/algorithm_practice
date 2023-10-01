import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int zero;
	static int fx = -1, fy = -1;
	
	public static void main(String[] args) throws IOException{
		
		map = new int[9][9];
		
		for (int i = 0; i < 9 ; i ++) {
			String str = br.readLine();
			
			for (int j = 0 ; j < 9 ; j ++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0) {
					zero++;
					if (fx == -1) {						
						fx = i;
						fy = j;
					}
				}
			}
		}
		
		sudoku(fx, fy);
		
	}
	
	
	static void sudoku(int x, int y) {
		
		if (zero == 0) {
			for (int i = 0 ; i < 9 ; i ++) {
				for (int j = 0 ; j < 9 ; j ++) {
					System.out.printf("%d", map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		boolean[] used = new boolean[10];
		
		for (int i = 0 ; i < 9 ; i ++) {
			if (map[x][i] != 0)
				used[map[x][i]] = true;
		}
		
		for (int i = 0 ; i < 9 ; i ++) {
			if (map[i][y] != 0)
				used[map[i][y]] = true;
		}
		
		for (int i = 3*(x/3) ; i < 3*(x/3)+3 ; i ++) {
			for (int j = 3*(y/3) ; j < 3*(y/3)+3; j ++) {
				if(map[i][j] != 0)
					used[map[i][j]] = true;
			}
		}
		
		for (int i = 1 ; i <= 9 ; i ++) {
			
			if (used[i] == false) {
				used[i] = true;
				map[x][y] = i;
				zero --;
				
				int nx = -1;
				int ny = -1;
				
				for (int t = x ; t < 9 ; t ++) {
					for(int k = 0 ; k < 9 ; k ++) {
						if (map[t][k] == 0 && nx == -1) {
							nx = t;
							ny = k;
						}
					}
				}
				
				sudoku(nx, ny);
				
				if (zero == 0) {
					return;
				}
				
				zero ++;
				map[x][y] = 0;
				used[i] = false;
			}
		}
	}
	
}