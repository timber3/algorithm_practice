import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, sum;
	static int[][] Map;
	static int[] col;
	static boolean[] rightDown, rightUp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		Map = new int[n+1][n+1];
		col = new int[n+1];
		rightDown = new boolean[2*n];
		rightUp = new boolean[2*n];
		
		solve(1, 0);
		
		System.out.println(sum);

	}
	
	static void solve(int row, int queens) {
		
		// 둔 자리가 성립하는지 검사
		if (!available(row-1)) {
			return;
		}
		
		// 다 뒀다면
		if (row > n) {
			sum ++;
			return;
		}
		
		// 퀸 두기
		for (int i = 1 ; i <= n ; i ++) {
			col[row] = i;
			
			if(rightDown[row - col[row] + n] || rightUp[row + col[row] -1]) {
				continue;
			}
			
			rightDown[(row - col[row]) + n] = true;  
			rightUp[row + col[row] -1] = true;
			
			solve(row + 1, queens + 1);
			
			rightDown[(row - i) + n] = false;  
			rightUp[i + row -1] = false; 
		}
		
	}
	
	static boolean available(int row) {
		
		for (int i = 1 ; i < row ; i ++) {
			if (col[i] == col[row])
				return false;
		}
		
		return true;
	}

}
