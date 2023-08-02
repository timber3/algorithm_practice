import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	static int n, T;
	static int[][] Map;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		T = sc.nextInt();
		
		for (int t = 0 ; t < T ; t++) {
			
			n = sc.nextInt();
			Map = new int[n][n];
			
			int r=0, c = -1, h = 1, idx = 1;
			
			while(n!=0) {
				
				for (int i = 0 ; i < n ; i ++) {
					Map[r][c + h] = idx;
					idx ++;
					c += h;
				}
				
				n--;
				
				for (int i = 0 ; i < n ; i ++) {
					Map[r+h][c] = idx;
					idx ++;
					r += h;
				}
				
				h *= -1;
				
			}
			System.out.printf("#%d\n", t+1);
			for (int[] i : Map) {
				for (int j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}

		}
		
	}

}
