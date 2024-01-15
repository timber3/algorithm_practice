import java.util.*;
import java.io.*;

public class Main {

	static int n, m, q;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
									
				map[i][j] = Integer.parseInt(st.nextToken());
				if (inRange(i-1, j)) {
					map[i][j] += map[i-1][j];
				}
				if(inRange(i-1, j-1)) {
					map[i][j] += map[i-1][j-1];
				}
				if(inRange(i-2, j-1)) {
					map[i][j] -= map[i-2][j-1];
				}
			}
		}
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			bw.write(map[a][b] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static boolean inRange(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= m) ? false : true;
	}

}