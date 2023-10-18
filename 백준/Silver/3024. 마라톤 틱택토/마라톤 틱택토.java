import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static String result = "ongoing";
	static char[][] map;
	
	static int dx[] = {0, 0, -1 ,1, 1, -1, -1, 1};
	static int dy[] = {1, -1, 0, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for (int i = 0 ; i < n ; i ++ ) {
			String str = br.readLine();
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		Loop1 :
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				
				if (map[i][j] != '.') {					
					for (int k = 0 ; k < 8 ; k ++ ) {
						
						int cnt = 1;
						char cur = map[i][j];
						
						for (int t = 1 ; t < 3 ; t ++) {
							int nx = i + dx[k] * t;
							int ny = j + dy[k] * t;
							
							if (nx < 0 || ny < 0 || nx >= n || ny >= n ) {
								break;
							}
							
							if (map[nx][ny] != cur) {
								break;
							}
							
							if (map[nx][ny] == cur)
								cnt++;						
						}
						
						if (cnt == 3) {
							result = cur+"";
							break Loop1;
						}
					}
				}
				
			}
		}
		
		System.out.println(result);
		
	}
}