import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Shark{
		int x;
		int y;
		int size;
		
		public Shark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {0, -1, 0 ,1};
	static int[] dy = {1, 0, -1, 0};

	static int n, m;
	static int[][] Map;
	static int[][] dist;
	static int PinkPong = 2;
	static int pink_x, pink_y;
	static int stomach;
	static int short_x, short_y;
	static int Min = 9999999;
	static int time = 0;
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		
		Map = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		
		// visited 배열 -1로 초기화
		for (int i = 0 ; i < n ; i ++) {
			Arrays.fill(dist[i], -1);
		}
		
		// 입력
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j ++) {
				Map[i][j]= Integer.parseInt(st.nextToken());
				
				if (Map[i][j]== 9 ) {
					pink_x = i;
					pink_y = j;
				}
			}
		}
		
		solve(pink_x, pink_y);
		
		System.out.println(time);
		
	}
	
	static void solve(int x, int y) {

		while(bfs(x, y, PinkPong)) {
			// 먹었으면
			
			stomach++;
			if (stomach == PinkPong) {
				stomach = 0;
				PinkPong++;
			}
			
			Map[pink_x][pink_y] = 0;
			pink_x = short_x;
			pink_y = short_y;
			Map[pink_x][pink_y] = 9;
			
			x = pink_x;
			y = pink_y;
			
			time += dist[pink_x][pink_y];
			
			for (int i = 0 ; i < n ; i ++) {
				Arrays.fill(dist[i], -1);
			}
			
			Min = 9999999;
			
		}

	}
	
	// 현재  (x,y) 에서 갈 수 있는 곳의 최단 거리를 구함.
	static boolean bfs(int x, int y, int size) {

		ArrayDeque<Shark> q = new ArrayDeque<>();
		
		q.add(new Shark(x, y, size));
		
		dist[x][y] = 0; 
		
		while(!q.isEmpty()) {
			Shark temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			int csize = temp.size;
			
			for (int i = 0 ; i < 4; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n
						|| dist[nx][ny] >= 0 ) {
					continue;
				}
				
				if (Map[nx][ny] == 0 || Map[nx][ny] <= csize) {
					dist[nx][ny] = dist[cx][cy] + 1;  
					q.add(new Shark(nx, ny, csize));
				}				
			}			
		}
		
		// 최단거리 전부 저장되어 있음.
		boolean can_eat = false;
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				if (dist[i][j] != -1 && dist[i][j] < Min
						&& Map[i][j] != 9 && Map[i][j] != 0
						&& Map[i][j] < PinkPong ) {
					short_x = i;
					short_y = j;
					Min = dist[i][j];
					can_eat = true;
				}
			}
		}
		
		if (!can_eat) {
			return false;
		}
		// 최단 인덱스, 최솟값 저장 함.
		return true;
	}

}
