import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, result;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			String str = br.readLine();
			for (int j = 0 ; j < n ; j ++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 가로로 한번 바꿔보기
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n-1 ; j ++) {
				char t = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = t;
				search();
				map[i][j+1] = map[i][j];
				map[i][j] = t;
				
			}
		}
		
		// 세로로 바꿔보기
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n-1 ; j ++) {
				char t = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = t;
				search();
				map[j+1][i] = map[j][i];
				map[j][i] = t;
				
			}
		}
		
		System.out.println(result);
	}
	
	static void search() {
		
		int count = 1;
		
		// 가로로 비교하기
		for(int i = 0 ; i < n ; i ++) {
			char before = ' ';
			for (int j = 0 ; j < n ; j ++) {
				if (map[i][j] == before) {
					count ++;
				} else {
					before = map[i][j];
					count = 1;
				}
				result = Math.max(count, result);
			}
		}
		
		// 세로로 비교하기
		for(int i = 0 ; i < n ; i ++) {
			char before = ' ';
			for (int j = 0 ; j < n ; j ++) {
				if (map[j][i] == before) {
					count ++;
				} else {
					before = map[j][i];
					count = 1;
				}
				result = Math.max(count, result);
			}
		}
	}

}