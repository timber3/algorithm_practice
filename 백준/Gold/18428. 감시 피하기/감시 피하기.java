import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static char[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j ++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		
		dfs(0, 0, 0);
		
		if(result == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	static void dfs(int cur, int x, int y) {
		if (cur == 3) {
			// 학생마다 사방을 탐색하며 T가 있는지 확인
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					if (map[i][j] == 'S') {
						
						for (int t = 0 ; t < 4 ; t ++) {
							int nx = i + dx[t];
							int ny = j + dy[t];
							
							while(nx >= 0 && ny >= 0 && nx < n && ny < n) {
								if (map[nx][ny] == 'O') {
									break;
								}
								if (map[nx][ny] == 'T') {
									// 너 T야? 했을 때 T가 있다면 그 경우는 바로 갖다 버리기;;
									return;
								}
								
								nx = nx + dx[t];
								ny = ny + dy[t];
							}
						}
					}
				}
			}
			
			// 모든 T를 걸러 냈다면
			result = 1;
			return;
		}
		
		for (int i = x ; i < n ; i ++, y=0) {
			for (int j = y ; j < n ; j++) {
				if (result == 1) {
					return;
				}
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(cur + 1, i, j);
					map[i][j] = 'X';
				}
			}
		}
	}
}