import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int x;
		int y;
		int dist;
		int num;
		
		public Node(int x, int y, int dist, int num) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.num = num;
		}
		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	// 궁수는 왼쪽부터 검사 한다. 밑으로는 검사 안함.
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	
	// 맵 복사용
	static int[][] originMap, Map;
	static boolean[] visited;
	static int[] castle;
	static int n, m, k, kill, Max;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		originMap = new int[n+1][m];
		Map = new int[n+1][m];
		
		visited = new boolean[m];
		castle = new int[3];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
				originMap[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		combi(0, 0);
		
		System.out.println(Max);
	}
	
	static void combi(int cnt, int idx) {
		// 시작 조건
		if (cnt == 3) {
			// 맵 초기화
						
			restore_map();
//			put_archer();
			
			while(!game_over()) {
				shoot();
//				print_cur_Map();
				monster_down();
			}
			
			Max = Math.max(Max, kill);
			kill = 0;
			return;
		}
		
		// 조합 생성기
		for (int i = idx ; i < m ; i ++) {
			if (!visited[i]) {
				visited[i]= true;
				castle[cnt] = i;
				combi(cnt+1, i+1);
				visited[i]= false; 
			}
		}
		
	}
	
	static void restore_map() {
		for (int i = 0 ; i < n; i ++) {			
			Map[i] = Arrays.copyOfRange(originMap[i], 0, m);
		}
	}
	
	static void put_archer() {
		for (int i = 0 ; i < m ; i ++) {
			Map[n][i] = castle[i];
		}
	}
	
	static boolean game_over() {
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				if (Map[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void shoot() {
		
		Queue<Node> q = new LinkedList<>();
		
		// 궁수 번호
		int archer = 0;
		// 궁수들 q에 넣기
		for (int i = 0 ; i < 3 ; i ++) {
			q.add(new Node(n, castle[i], 0, archer++)); 
		}
		
		
		// 궁수 별 최소 거리 좌표
		int[] hx = new int[3];
		int[] hy = new int[3];
		
		// 최단 거리를 발견 했으면 더 이상 탐색 안하도록
		boolean[] found = new boolean[] {false, false, false};
		
		// bfs
		// 탐색을 사거리 범위보다 작은 곳으로만 하기.
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			int cd = temp.dist;
			int cnum = temp.num;
			
			// 거리가 사정거리 밖이라면
			if (cd > k)
				continue;
			
			// 이미 발견한 아쳐의 노드를 꺼냈다면
			if (found[cnum])
				continue;
			
			// 해당 위치가 괴물이 있다면 최단거리가 보장되므로 최단거리에 넣어준 후 좌표 고정
			if (Map[cx][cy] == 1) {
				hx[cnum] = cx;
				hy[cnum] = cy;
				found[cnum] = true; 
				continue;
			}
			
			// 
			for (int i = 0 ; i < 3 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m ) {
					continue;
				}
				
				q.add(new Node(nx, ny, cd+1, cnum));
			}
		}
		
		// 궁수 별 위치 다 찍었음. (found가 true인 궁수들)
		for (int i = 0 ; i < 3 ; i ++) {
			// 궁수가 좌표를 잡았으면 ( 공격 대상이 있으면 )
			if (found[i]) {
				
				// 그 자리에 1로 채워져 있으면 ( 죽이지 않은 대상이라면 ) (중복으로 공격할 수 있기 떄문)
				if (Map[hx[i]][hy[i]] == 1) {
					Map[hx[i]][hy[i]] = 0;
					kill++;
				}
			}
		}
	}
	
	
	static void monster_down() {
		for (int i = n-1 ; i >= 0 ; i--) {
			for (int j = 0 ; j < m ; j ++) {
				if (i == 0) {
					Map[i][j] = 0; 					
				} else {					
					Map[i][j] = Map[i-1][j]; 
				}
				
			}
		}
	}
	
	static void print_cur_Map() {
		System.out.println("=============================");
		for (int i = 0 ; i < n+1 ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				System.out.print(Map[i][j]+ " " );
			}
			System.out.println();
		}
		System.out.println("=============================");
	}
	
}
