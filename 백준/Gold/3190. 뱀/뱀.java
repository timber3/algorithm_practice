import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		
		Node (int x , int y ){
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {0, -1, 0 ,1};
	static int[] dy = {1, 0, -1, 0};
	
	static int[][] Map;
	static char[] dir;
	static int[] sec;
	static int cur;
	static int idx;
	static int n, k, l;
	static ArrayDeque<Node> snake = new ArrayDeque<Node>();
	static int head_dir = 0;

	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		// 1 : 뱀   2 : 사과
		Map = new int[n+1][n+1];
		
		for (int i = 0 ; i < k ; i ++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			
			Map[ax-1][ay-1] = 2; 
		}
		
		l = Integer.parseInt(br.readLine());
		dir = new char[l+1];
		sec = new int[l+1];
		
		// L : 왼쪽     D : 오른쪽
		for (int i = 0 ; i < l ; i ++) {
			st = new StringTokenizer(br.readLine());
			sec[i] = Integer.parseInt(st.nextToken());
			dir[i]= st.nextToken().charAt(0); 
		}
		
		snake.addFirst(new Node(0, 0));
		Map[0][0] = 1;
		
		
		// 뱀 이동 시작
		while(true) {
			int cx = snake.peekFirst().x;
			int cy = snake.peekFirst().y;
			int nd = head_dir;
			
			// 현재 방향 전환이 필요하다면
			if (cur == sec[idx]) {
				if (dir[idx] == 'L') {
					nd = (head_dir + 1) % 4;
				} else {
					nd = (head_dir + 3) % 4;
				}
				head_dir = nd;
				idx++;
			}
			
			// 다음 방향 선정
			int nx = cx + dx[nd];
			int ny = cy + dy[nd];
			
			// Map을 벗어나거나 자기 자신을 만났을 때
			if ( nx < 0 || ny < 0 || nx >= n || ny >= n || Map[nx][ny] == 1 ) {
				break;
			}
			
			// 다음 방향에 사과가 있을 경우
			if (Map[nx][ny] == 2 ) {
				snake.addFirst(new Node(nx, ny));
				Map[nx][ny]= 1; 
			}
			else {				
				snake.addFirst(new Node(nx, ny));
				Map[nx][ny]= 1; 
				Node t = snake.pollLast();
				Map[t.x][t.y] = 0; 
			}
			
			cur ++;
		}
		
		System.out.println(cur+1);
		
	}

}
