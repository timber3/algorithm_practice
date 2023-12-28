import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, result;
	static int[][] map, visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1 ,0, 0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j< m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				visited[i][j] = 1;
				bt(0, i, j, map[i][j]);
				visited[i][j] = 0;
			}
		}
		
		oh();
		
		System.out.println(result);
	}
	
	static void bt(int cur, int x , int y, int sum) {
		
		if (cur == 3) {

			result = Math.max(result, sum);
			
			return;
		}
		
		for (int d = 0 ; d < 4 ; d ++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(inRange(nx, ny)) {
				if (visited[nx][ny] == 0) {				
					visited[nx][ny] = 1;
					bt(cur + 1, nx, ny, sum + map[nx][ny]);
					visited[nx][ny] = 0;
				}
			}
		}
	}
	
	static void oh() {
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				// ㅗ 자 모양을 4방향으로 돌려가면서 확인 해줘야 함
				int sum = 0;
				
				if (inRange(i+1, j) && inRange(i, j+1) && inRange(i+1, j+1) && inRange(i+1, j+2)) {
					sum = map[i+1][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
					result = Math.max(result, sum);
				}
				if (inRange(i, j) && inRange(i, j+1) && inRange(i+1, j+1) && inRange(i, j+2)) {
					sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
					result = Math.max(result, sum);
				}
				if (inRange(i, j) && inRange(i+1, j) && inRange(i+1, j+1) && inRange(i+2, j)) {
					sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
					result = Math.max(result, sum);
				}
				if (inRange(i, j+1) && inRange(i+1, j) && inRange(i+1, j+1) && inRange(i+2, j+1)) {
					sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
					result = Math.max(result, sum);
				}
				
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= m) ? false : true;
	}
}