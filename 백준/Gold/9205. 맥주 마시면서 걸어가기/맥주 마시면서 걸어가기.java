import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n;
	static boolean[][] map;
	static boolean[] visited;
	static Node[] input;
	
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int T = 0 ; T < t ; T++) {
			
			n = Integer.parseInt(br.readLine());
			
			map = new boolean[n+2][n+2];
			
			input = new Node[n+2];
			
			for (int i = 0 ; i < n+2 ; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				input[i] = new Node(x, y);

			}
			
			// 0 : 시작점
			// n+1 : 도착점
			
			for (int i = 0 ; i < n+2 ; i ++) {
				for (int j = 0 ; j < n+2 ; j++) {
					if (i != j) {
						// 두 지점의 거리 차이가 1000 이하면
						if (Math.abs((input[i].x - input[j].x)) + Math.abs((input[i].y - input[j].y)) <= 1000) {
							map[i][j] = true;
							map[j][i] = true;
						}
					}
				}
			}
			
			bfs();
			
			if (visited[n+1])
				System.out.println("happy");
			else
				System.out.println("sad");

		}
		
		
		
	}
	
	static void bfs() {
		visited  = new boolean[n+2];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			
			for (int i = 0 ; i < n+2 ; i ++) {
				if (map[cur][i] == true && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}