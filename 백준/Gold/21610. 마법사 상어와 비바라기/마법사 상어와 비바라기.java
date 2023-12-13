import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, m, sum;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1 };
	
	static int[][] map;
	static boolean[][] cloud, visited;
	static int[] dir, dis;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		cloud = new boolean[n][n];
		dir = new int[m];
		dis = new int[m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < n ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			dir[i] = Integer.parseInt(st.nextToken())-1;
			dis[i] = Integer.parseInt(st.nextToken()) % n;
		}
		
		//(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1) 에 생김
		cloud[n-1][0] = true;
		cloud[n-1][1] = true;
		cloud[n-2][0] = true;
		cloud[n-2][1] = true;
		
		for (int i = 0 ; i < m ; i ++) {
			move(i);
			rain();
			makeCloud();
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	static void move(int idx) {
		boolean[][] temp = new boolean[n][n];
		
		// 구름을 찾아서 움직여주기
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				if (cloud[i][j]) {			
					int nx = (i + (dis[idx] * dx[dir[idx]]) )%n;
					int ny = (j + (dis[idx] * dy[dir[idx]]) )%n;
					
					if (nx < 0 ) nx += n;
					if (ny < 0 ) ny += n;
					
					temp[nx][ny] = true;
				}
			}
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				cloud[i][j] = temp[i][j];
			}
		}
		
	}
	
	static void rain() {
		// 구름 삭제했는지 확인하는 배열
		visited = new boolean[n][n];
		
		int[][] temp = new int[n][n];
		
		
		// 비는 일단 다 내려야 됨.
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j ++) {
				if(cloud[i][j]) {
					// 비 내리기
					map[i][j] ++;
					// 구름 삭제
					cloud[i][j] = false;
					visited[i][j] = true;
				}
			}
		}
		
		// 임시 복사 배열 생성.
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j ++) {
				temp[i][j] = map[i][j];
			}
		}
		
		// 물복사 버그 시전
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j ++) {
				// 구름이 있던 자리라면
				if(visited[i][j]) {
					// 물 복사 버그 시전
					int count = 0;
					
					for (int k = 1 ; k < 8 ; k += 2) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
							continue;
						}
						
						if (temp[nx][ny] != 0) {
							count ++;
						}
					}
					
					map[i][j] += count;
					// 물 복사 버그 끝
				}
			}
		}
	}

	static void makeCloud() {
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				if ( !visited[i][j] && map[i][j] >= 2) {
					cloud[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}
	}
	
	
}