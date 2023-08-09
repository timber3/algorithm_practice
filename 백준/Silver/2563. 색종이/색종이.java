import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] Map = new int[101][101];
	static int n;
	static int x;
	static int y;
	static int sum;
	
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n ; t ++) {
			
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int i = x ; i < x + 10 ; i ++) {
				for (int j = y ; j < y + 10 ; j++ ) {
					Map[i][j]= 1; 
				}
			}
		}
		
		for (int i = 0 ; i < 101; i ++) {
			for (int j = 0 ; j < 101 ; j ++) {
				if (Map[i][j]== 1 ) 
					sum ++;
			}
		}
		
		System.out.println(sum);
		
	}
	
	
}
