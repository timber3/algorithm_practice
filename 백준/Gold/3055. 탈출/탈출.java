import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
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
	
	static int r, c, sX, sY, dX, dY;
	static char[][] map;
	static int[][] waterDis;
	static int[][] dist;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static ArrayList<Node> water = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		waterDis = new int[r][c];
		dist = new int[r][c];
		
		for (int i = 0 ; i < r ; i ++) {
			String str = br.readLine();
			
			for (int j = 0 ; j < c ; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*') {
					water.add(new Node(i,j));
				}
				if (map[i][j] == 'S') {
					sX = i;
					sY = j;
				}
				if (map[i][j] == 'D') {
					dX = i;
					dY = j;
				}
			}
		}
		
		// . : 빈곳    * : 물   X : 돌
		// D : 비버 굴   S : 고슴도치
		
		bfs();
		
		if (dist[dX][dY] == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(dist[dX][dY]);
		}
		
	}
	
	static void bfs() {
		// 물이 퍼지는 시간 기록 map -1 로 초기화 해주기
		for (int i = 0 ; i < r ; i ++) {
			for (int j = 0 ; j < c ; j ++) {
				waterDis[i][j] = 9999;
				dist[i][j] = -1;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		// 현재 거리는 0으로 초기화 하면서 모든 물 큐에 넣어주기
		for (int i = 0 ; i < water.size() ; i ++) {
			Node temp = water.get(i);
			waterDis[temp.x][temp.y] = 0; 
			q.add(temp);
		}
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			int cx = temp.x;
			int cy = temp.y;
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || waterDis[nx][ny] != 9999)
					continue;
				
				if (map[nx][ny] == 'X' || map[nx][ny] == 'D')
					continue;
				
				waterDis[nx][ny] = waterDis[cx][cy] + 1;
				q.add(new Node(nx, ny));
			}
		}
		
		
		q.add(new Node(sX, sY));
		dist[sX][sY] = 0;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || dist[nx][ny] != -1)
					continue;
				
				if (map[nx][ny] == 'X' || map[nx][ny] == '*')
					continue;
				
				if (map[nx][ny] != 'D') {				
					if (waterDis[nx][ny] <= dist[cx][cy] + 1) 
						continue;
					
					dist[nx][ny] = dist[cx][cy] + 1;
					q.add(new Node(nx,ny));
					
				} else {
					dist[nx][ny] = dist[cx][cy] + 1;
					q.add(new Node(nx,ny));
					continue;
				}
					
			}
		}
		
	}
}