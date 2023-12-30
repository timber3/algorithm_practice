import java.util.*;
import java.io.*;

public class Main {

	static int n, m, result;
	static int[][] map;
	static boolean[][] visited;
	
	// 동 남 서 북 (오른쪽으로 90도씩 회전 )
	static int[] dx = {0 ,1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited= new boolean[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bt(0, 0, 0, visited);
		
		System.out.println(result);
	}
	
	static void bt(int x, int y, int sum, boolean[][] visited) {
		
		if (sum > result) {
			result = Math.max(sum, result);
		}
		
		// 현재 상태에서 부메랑을 만들 수 있는지 확인하기.
		for (int i = x; i < n ; i ++) {
			for (int j = y; j < m ; j ++, y = 0) {
				
				if (!visited[i][j]) {					
					int cx = i;
					int cy = j;
					
					for (int d = 0 ; d < 4 ; d ++) {
						int nx = cx + dx[d];
						int ny = cy + dy[d];
						
						int nx2 = cx + dx[(d+1)%4];
						int ny2 = cy + dy[(d+1)%4];
						
						// 부메랑 모양이 만들어 져야 함. ( 부메랑을 만듦
						if (inRange(nx, ny) && inRange(nx2, ny2)) {
							// 두 자리 모두 사용이 가능 하다면
							
							if (!visited[nx][ny] && !visited[nx2][ny2] ) {
								visited[cx][cy] = true;
								visited[nx][ny] = true;
								visited[nx2][ny2] = true;
								int temp = map[nx][ny] + map[nx2][ny2] + (map[cx][cy] * 2);
								bt(i, j, sum + temp, visited);
								visited[cx][cy] = false;
								visited[nx][ny] = false;
								visited[nx2][ny2] = false;
							}
						}
						
					}
				}
				
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= m ) ? false : true;
				
	}

}