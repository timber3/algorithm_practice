import java.util.*;
import java.io.*;

public class Main {

	static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, v_count;
	static int min = Integer.MAX_VALUE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static int[][] map, visited;
	static Virus[] virus;
	static Virus[] using;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int temp = (int)Math.pow(n, 2);
		map = new int[n][n];
		virus = new Virus[temp];
		using = new Virus[m];
		used = new boolean[m];

		// 0 빈칸, 1 벽, 2 바이러스
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus[v_count] = new Virus(i, j);
					v_count ++;
				}
			}
		}
		
		combination(0, 0);
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else if (min == 0) {
			System.out.println(min);
		} else {
			System.out.println(min-1);
		}
		
	}

	static void combination(int cur, int idx) {
		if (cur == m) {
			bfs();
			return;
		}

		for (int i = idx; i < v_count ; i ++) {
			using[cur] = virus[i];
			combination(cur+1, i+1);
		}
	}

	static void bfs() {

		visited = new int[n][n];
		
		Queue<Virus> q = new ArrayDeque<>();
		
		// visited == 0  => 접근한 적 없는 곳
		for (int i = 0 ; i < m ; i++) {
			Virus temp = using[i];
			int cx = temp.x;
			int cy = temp.y;
			
			visited[cx][cy] = 1;
			
			q.add(temp);
		}
		
		while(!q.isEmpty()) {	
			Virus temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			
			for (int d = 0 ; d < 4 ; d ++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != 0 || map[nx][ny] == 1) {
					continue;
				}
					
				visited[nx][ny] = visited[cx][cy] + 1;
				
				q.add(new Virus(nx, ny));
			}			
		}
		
		int max = 0;
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				// 모든 칸에 전부 퍼졌는지 확인하기
				// 퍼지지 않은 곳이 있다면 끝내기.
				if (visited[i][j] == 0 && map[i][j] != 1 && map[i][j] != 2) {
					return;
				}
				
				if (max < visited[i][j] && map[i][j] != 2) {
					max = visited[i][j];
				}		
			}
		}
		min = Math.min(max, min);
	}
}