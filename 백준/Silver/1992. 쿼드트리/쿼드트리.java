import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[][] Map;
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		
		Map = new int[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			String temp = br.readLine();
			for(int j =0 ; j < n ; j ++) {
				Map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		solve(n, 0, 0);
	}
	
	static void solve(int cur, int top, int left) {
		if (cur == 0) {
			return;
		}
		
		int val = Map[top][left];
		
		for (int i = top ; i < cur + top ; i ++) {
			for (int j = left ; j < cur + left ; j ++) {
				
				if (val != Map[i][j]) {
					System.out.print('(');
					solve(cur/2, top, left);
					solve(cur/2, top, left + cur/2);
					solve(cur/2, top + cur/2, left);
					solve(cur/2, top + cur/2, left + cur/2);
					System.out.print(')');
					return;
				}
			}
		}
		System.out.print(val);
	}
}
