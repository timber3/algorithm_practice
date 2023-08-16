import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, cur;
	static int[][] Map;
	static int[] area;
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		area = new int[2];
		Map = new int[n][n];

		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cur = n;
		solve(n, 0, 0);
		System.out.println(area[0]);
		System.out.println(area[1]);
	}
	
	static void solve(int cur, int top, int left) {
		
		int val = Map[top][left];
		
		for (int i = top; i < cur + top ; i ++) {
			for (int j = left ; j < cur + left ; j ++) {
				if (val != Map[i][j]) {
					solve(cur/2, top, left);
					solve(cur/2, top, left + cur/2);
					solve(cur/2, top + cur/2, left);
					solve(cur/2, top + cur/2, left + cur/2);
					return;
				}
			}
		}
		
		area[val]++;
	}

}
