import java.util.*;
import java.io.*;

public class Main {
	
	static class Shark {
		int spd;
		int dir;
		int size;
		public Shark(int spd, int dir, int size) {
			this.spd = spd;
			this.dir = dir;
			this.size = size;
		}
		@Override
		public String toString() {
			return "[spd=" + spd + ", dir=" + dir + ", size=" + size + "]";
		}
		
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dx = { 1, 0, -1, 0};
	static int[] dy = { 0, -1, 0, 1};
	
	static int r, c, m;
	static ArrayList<Shark>[][] Map;
	static ArrayList<Shark>[][] tempMap;
	static int sum;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new ArrayList[r][c];

		
		for (int i = 0 ; i < r ; i ++ ) {
			for (int j = 0 ; j < c ; j ++ ) {
				Map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0 ; i < m ; i ++ ) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int spd = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken())-1;
			int size = Integer.parseInt(st.nextToken());
			
			if (dir == 0)
				Map[x][y].add(new Shark(spd, 2, size));
			if (dir == 1)
				Map[x][y].add(new Shark(spd, 0, size));
			if (dir == 2)
				Map[x][y].add(new Shark(spd, 3, size));
			if (dir == 3)
				Map[x][y].add(new Shark(spd, 1, size));
			
		}
		
		for (int i = 0 ; i < c ; i ++ ) {
			hunt(i);
			moveShark();
		}
		
		System.out.println(sum);
	}
	
	static void hunt(int cur) {
		for (int i = 0 ; i < r ; i ++) {
			if (Map[i][cur].size() == 1) {
				sum += Map[i][cur].get(0).size;
				Map[i][cur].remove(0);
				return;
			}
		}
	}
	
	static void moveShark() {
		
		tempMap = new ArrayList[r][c];
		
		for (int i = 0 ; i < r ; i ++ ) {
			for (int j = 0 ; j < c ; j ++ ) {
				tempMap[i][j] = new ArrayList<>();
			}
		}

		// 격자를 모두 돌면서
		for (int i = 0 ; i < r ; i ++ ) {
			for (int j = 0 ; j < c ; j ++ ) {
				// 만약 상어가 그 자리에 있다면
				if (Map[i][j].size() == 1) {
					
					Shark shark = Map[i][j].get(0);
					int cx = i;
					int cy = j;
					int cd = shark.dir;
					int cspd = shark.spd;
					int originspd = cspd;
					int csize = shark.size;
					
					int nd = cd, nx = cx , ny = cy;
					
					if (cd == 0 || cd == 2) {
						cspd = cspd % ((r-1) * 2);
					}
					
					if (cd == 1 || cd == 3) {
						cspd = cspd % ((c-1) * 2);
					}
					
					for (int k = 0 ; k < cspd  ; k ++ ) {
						
						nx = cx + dx[nd];
						ny = cy + dy[nd];
						
						// 범위를 벗어났으면 머리를 돌려주고 움직여 주기
						if (nx < 0 || ny < 0 || nx >= r || ny >= c ) {
							nd = (nd + 2) % 4;
							nx = cx + dx[nd];
							ny = cy + dy[nd];
						}
						
						cx = nx;
						cy = ny;
						
					}
					
					tempMap[nx][ny].add(new Shark(originspd, nd, csize));
				}
			}
		}
		
		Map = tempMap;
		
		// Map 내 모든 상어가 움직였으면 같은 자리에 있는 상어 정리하기
		
		for (int i = 0 ; i < r ; i ++) {
			for (int j = 0 ; j < c ; j ++ ) {
				if ( Map[i][j].size() > 1 ) {
					Shark temp = Collections.max(Map[i][j], (a, b) -> {
						return a.size - b.size;
					} );
					
					Map[i][j].clear();
					Map[i][j].add(temp);
				}
			}
		}
		
	}
	
}
