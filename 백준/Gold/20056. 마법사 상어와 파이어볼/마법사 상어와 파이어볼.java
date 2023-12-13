import java.util.*;
import java.io.*;

public class Main {
	
	static class Fireball{
		int m;
		int s;
		int d;
		public Fireball(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Fireball [m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, m, k, sum;
	static ArrayList<Fireball>[][] map;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			//map[i] = new ArrayList[n];
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[x][y].add(new Fireball(m,s,d));
		}
		
		for (int i = 0 ; i < k ; i++) {
			move();
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				for (int k = 0 ; k < map[i][j].size(); k++) {					
					sum += map[i][j].get(k).m;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	static void move() {
		
		
		ArrayList <Fireball>[][] temp = new ArrayList[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			//temp[i] = new ArrayList[n];
			for (int j = 0 ; j < n ; j ++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0 ; i < n ; i ++ ) {
			for (int j = 0 ; j < n ; j ++) {
				for (int k = 0 ; k < map[i][j].size(); k ++) {
					
					Fireball cur = map[i][j].get(k);
					
					int cm = cur.m;
					int cs = cur.s;
					int cd = cur.d;
					
					int nx = (i + (dx[cd] * cs)) % n;
					int ny = (j + (dy[cd] * cs)) % n;
					
					if(nx < 0) nx += n;
					if(ny < 0) ny += n;
					
					temp[nx][ny].add(new Fireball(cm, cs, cd));
				}
			}
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if (temp[i][j].size() >= 2) {
					int sumM = 0;
					int sumS = 0;
					boolean dirE = false;
					boolean dirO = false;
					
					for (int k = 0 ; k < temp[i][j].size(); k++) {
						sumM += temp[i][j].get(k).m;
						sumS += temp[i][j].get(k).s;
						if (temp[i][j].get(k).d % 2 == 0)
							dirE = true;
						else
							dirO = true;
					}
					
					int avgS = sumS / temp[i][j].size();
					int avgM = sumM / 5;
					
					// 일단 해당 칸에 파이어볼 다 비워주고
					temp[i][j].clear();
					
					// 질량의 합 / 5 했을 때 0이면 사라져야함.
					if (avgM != 0) {
						if (dirE && dirO) {
							// 1, 3, 5, 7
							for (int t = 1 ; t < 8 ; t += 2) {
								temp[i][j].add(new Fireball(avgM, avgS, t));
							}
						} else {
							// 0, 2, 4, 6
							for (int t = 0 ; t < 8 ; t += 2) {
								temp[i][j].add(new Fireball(avgM, avgS, t));
							}
						}
					}
				}
			}
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				map[i][j].clear();
				for (int k = 0 ; k < temp[i][j].size(); k++) {					
					map[i][j].add(temp[i][j].get(k));
				}
			}
		}
		
	}
}