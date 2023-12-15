import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, tx, ty, sum;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int sprx[][] = {
			{-1, 1, -1, 1, -2, 2, 0, -1, 1, 0},
			{1, 1, 0, 0, 0, 0, 2, -1, -1, 1},
			{1, -1, 1, -1, 2, -2, 0, 1, -1, 0},
			{-1, -1, 0, 0, 0, 0, -2, 1, 1, -1}
	};
	static int spry[][] = {
			{-1, -1, 0, 0, 0, 0, -2, 1, 1, -1},
			{-1, 1, -1, 1, -2, 2, 0, -1, 1, 0},
			{1, 1, 0, 0, 0, 0, 2, -1, -1, 1},
			{1, -1, 1, -1, 2, -2, 0, 1, -1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		tx = ty = n/2;
		
		map = new int[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		spreadSand();
		
		System.out.println(sum);
	}
	static void spreadSand() {
		int cur = 0;
		int idx = 1;
		
		while( true ) {
			
			if (tx == 0 && ty == 0) {
				break;
			}
			
			for (int i = 0 ; i < idx ; i ++) {
				int nx = tx + dx[cur];
				int ny = ty + dy[cur];
				
				if (inRange(nx ,ny)) {
					inOrOut(nx, ny, cur);					
				} else {
					break;
				}
				
				tx = nx;
				ty = ny;
			}
			
			cur++;
			cur = cur % 4;
			
			if (tx == 0 && ty == 0) {
				break;
			}
			
			for (int i = 0 ; i < idx ; i ++) {
				int nx = tx + dx[cur];
				int ny = ty + dy[cur];
				
				if (inRange(nx ,ny)) {
					inOrOut(nx, ny, cur);					
				} else {
					break;
				}
				
				tx = nx;
				ty = ny;
			}
			
			idx ++;
			cur++;
			cur = cur % 4;
			
		}
	}
	
	static boolean inRange(int nx, int ny) {
		
		if (nx < 0 || ny < 0 || nx >= n || ny >= n ) {
			return false;
		}
		
		return true;
	}
	
	static void inOrOut(int x, int y, int dir) {
		int used = 0;
		
		// 10 %
		used += cal(x, y, dir, 0, 10);
		used += cal(x, y, dir, 1, 10);
		// 7 %
		used += cal(x, y, dir, 2, 7);
		used += cal(x, y, dir, 3, 7);
		// 2 %
		used += cal(x, y, dir, 4, 2);
		used += cal(x, y, dir, 5, 2);
		// 5 %
		used += cal(x, y, dir, 6, 5);
		// 1 %
		used += cal(x, y, dir, 7, 1);
		used += cal(x, y, dir, 8, 1);
		
		// a 계산
		int rest = map[x][y] - used;
		int ax = x + sprx[dir][9];
		int ay = y + spry[dir][9];
		
		if (inRange(ax, ay)) {
			map[ax][ay] += rest;
		} else {
			sum += rest;
		}
		map[x][y] = 0;
	}
	
	static int cal(int x, int y, int dir, int idx, int percent) {
		
		int val = map[x][y] * percent / 100;
		
		if (inRange(x + sprx[dir][idx] , y + spry[dir][idx])) {
			map[x + sprx[dir][idx]][y + spry[dir][idx]] += val; 
		} else {
			sum += val;
		}
		
		return val;
	}
	
}