import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] swing;  // 몇 이닝에서 몇번 타자의 스윙 결과
	static int[] lane;  // 베이스
	static int[] batter;   // 몇번째 타자는 누구인지
	static boolean[] selected;   // 몇번째 타자의 순서가 정해졌는지
	static int score, result;
	
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
	
		swing = new int[n+1][10];
		selected = new boolean[10];
		batter = new int[10];
		lane = new int[4];
		
		for (int i = 1 ; i <= n ; i ++) {			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1 ; j <= 9 ; j ++) {
				swing[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		batter[4] = 1;   // 4번째 타자는 1번 선수가 함.
		selected[1] = true;  // 1번 타자는 사용중
		
		perm(1);
		
		System.out.println(result);
		
	}
	
	static void perm(int cnt) {
		
		if (cnt == 4) {
			perm(cnt+1);
			return;
		}
		
		// 모든 선수의 타순이 정해졌으면
		if ( cnt == 10 ) {
			// 경기 진행
			score = 0;
			int out = 0;			
			int idx = 1;
			int now = 1;
			
			while (now <= n) {
				
				if (out == 3) {
					// 공수 교대 ( 베이스 초기화 )
					Arrays.fill(lane, 0);
					now ++;
					out = 0;
					continue;
				}
					
				while (out != 3) {					
					// now 이닝의 idx 번째 타자의 스윙 결과에 따라
					switch (swing[now][batter[idx]]) {
					case 1:
						hit(1);
						break;
					case 2:
						hit(2);
						break;
					case 3:
						hit(3);
						break;
					case 4:
						hit(4);
						break;
					case 0:
						out ++;
						break;
					}
					
					idx ++;
					if (idx == 10)
						idx = 1;
				}
				
			}
			
			
			// 경기 끝
			result = Math.max(result, score);
			return;
		}
		
		for (int i = 2 ; i <= 9 ; i ++) {
			// i 번째의 타자가 사용중이 아니라면
			if (!selected[i]) {
				// cnt 번째의 타자는 i다.
				batter[cnt] = i; 
				selected[i] = true;
				perm(cnt + 1);
				selected[i] = false;
			}
		}
	}
	
	
	static void hit(int k) {
		lane[0] = 1;
		for (int i = 3 ; i >= 0 ; i --) {
			if (lane[i] == 1) {
				// 달려서 점수가 나면
				if (i + k >= 4) {
					score ++;
					lane[i] = 0;
				} 
				// 달려서 점수가 안나면
				else {
					lane[i+k] = 1;
					lane[i] = 0; 
				}
			}
		}
		
	}
	
	
}

