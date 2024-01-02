import java.util.*;
import java.io.*;


public class Main {

	static int[][] gear;
	static boolean[] visited;
	static int k, result, T;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		gear = new int[T][8];
		
		// N극 - 0,  S극 - 1
		for (int t = 0 ; t < T ; t ++) {			
			String str = br.readLine();
			for (int i = 0 ; i < 8 ; i ++) {
				gear[t][i] = str.charAt(i) - '0';
			}
		}
		
		
		k = Integer.parseInt(br.readLine());
		
		// a : 돌리는 기어의 번호   b : 방향 ( 1 - 시계방향, -1 - 반시계방향 )
		for (int i = 0 ; i < k ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			
			visited = new boolean[T];
			
			roll(a, b);
		}
		
		for (int i = 0 ; i < T ; i ++) {
			result += gear[i][0];
		}
		
		System.out.println(result);
	}
	
	// 재귀로 움직임
	static void roll(int a, int b) {
		// 움직였으면 항상 왼쪽과 오른쪽을 봐야 함.
		// 그런데 왼쪽이 -1 이거나 오른쪽이 4이면 이런 애들은 안봄
		visited[a] = true;
		
		int gearRight = gear[a][2];
		int gearLeft = gear[a][6];
		
		// 시계방향으로 돌리기
		if (b == 1) {
			int temp = gear[a][7];
			for (int i = 7 ; i > 0 ; i --) {
				gear[a][i] = gear[a][i-1];
			}
			gear[a][0] = temp;
		} else {
			int temp = gear[a][0];
			for (int i = 0 ; i < 7 ; i ++) {
				gear[a][i] = gear[a][i+1];
			}
			gear[a][7] = temp;
		}
		
		// 왼쪽 기어가 1. 범위를 벗어나는지 확인 2. 극이 다른지 3. 돌린 적이 없는지 확인
		if ((a - 1 >= 0) && gear[a-1][2] != gearLeft && !visited[a-1]) {
			roll(a-1, b * -1);
		}
		
		// 오른쪽도 똑같이
		if ((a + 1 <= T-1) && gear[a+1][6] != gearRight && !visited[a+1]) {
			roll(a+1, b * -1);
		}
	}
}