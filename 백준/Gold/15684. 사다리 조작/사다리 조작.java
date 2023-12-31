import java.util.*;
import java.io.*;

public class Main {

	static int n, m, h, result;
	static int[][] map;
	static boolean find;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n];
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			map[a][b] = 1;
		}
		
		result = -1;
		// 0, 1, 2, 3 각 각 해보고 안되면 -1 출력
		// 백트래킹을 0부터 해보면 될 것 같음
		for (int i = 0 ; i < 4; i ++) {
			bt(0, 0, 0, i);
		}
		
		System.out.println(result);
	}
	
	// 가로줄을 어디서부터 둘 지 for문을 돌기 위한 x, y
	static void bt(int x, int y, int cur, int cnt) {

		if (find)
			return;
		
		if (cur == cnt) {
			// 시뮬레이션 동작
			// i = 세로줄 번호  j = 깊이
			for (int i = 0 ; i < n ; i ++) {
				int curLine = i;
				
				for (int j = 0 ; j < h ; j ++) {
					boolean flag = false;
					if (map[j][curLine] == 1) {
						curLine = curLine + 1;
						flag = true;
					}
					if (inRange(j, curLine-1) && map[j][curLine-1] == 1 && !flag) {
						curLine = curLine - 1;
					}
				}
				
				if (curLine != i) {
					return;
				}
			}
			
			// 다 돌았는데 각 번호랑 결과가 매칭된다면
			find = true;
			result = cur;
			return;
		}
		
		if (find)
			return;
		
		// 가로줄 설치
		for (int i = x ; i < h ; i ++) {
			for (int j = y ; j < n ; j++, y=0) {
				// 일단 그 자리에 가로줄이 없다면
				if (map[i][j] == 0) {
					boolean chk = false;
					// 해당 줄 왼쪽, 오른쪽 확인 해야함. ( 줄이 있으면 두면 안 됨)
					if (inRange(i, j-1) && map[i][j-1] == 1) {
						chk = true;
					}
					if (inRange(i, j+1) && map[i][j+1] == 1) {
						chk = true;
					}
					
					if (!chk && j != n-1) {
						map[i][j] = 1;
						bt(i, j, cur+1, cnt);
						map[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	static boolean inRange(int x, int y) {
		return ( x < 0 || y < 0 || x >= h || y >= n) ? false : true;
	}

}