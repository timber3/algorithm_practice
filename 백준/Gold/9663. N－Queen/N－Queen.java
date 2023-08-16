import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, sum;
	static int[][] Map;
	static boolean[] col;
	static boolean[] rightDown, rightUp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		Map = new int[n+1][n+1];
		col = new boolean[n+1];
		rightDown = new boolean[2*n];
		rightUp = new boolean[2*n];
		
		solve(1);
		
		System.out.println(sum);

	}
	
	static void solve(int row) {
		
		// 다 뒀다면
		if (row > n) {
			sum ++;
			return;
		}
		
		// 퀸 두기
		for (int i = 1 ; i <= n ; i ++) {
			if(col[i] || rightDown[row - i + n] || rightUp[row + i -1]) {
				continue;
			}
			
			col[i] = true;
			rightDown[(row - i) + n] = true;  
			rightUp[row + i -1] = true;
			
			solve(row + 1);
			
			col[i] = false; 
			rightDown[(row - i) + n] = false;  
			rightUp[i + row -1] = false; 
		}
		
	}
	
}
